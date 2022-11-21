package com.tencent.wxcloudrun.controller;

import cn.hutool.crypto.SecureUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lark.oapi.core.utils.Strings;
import com.tencent.wxcloudrun.dto.PublicRequest;
import com.tencent.wxcloudrun.dto.ReturnResponse;
import com.tencent.wxcloudrun.entity.Root;
import com.tencent.wxcloudrun.fs.FeiShuAPI;
import com.tencent.wxcloudrun.pojo.Fields;
import com.tencent.wxcloudrun.pojo.JsonRootBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.List;

/**
 * counter控制器
 */
@RestController
public class CounterController {

  //  final CounterService counterService;
  final Logger logger;
  final String TOKEN = "wxnf";

  public CounterController() {
//    this.counterService = counterService;
    this.logger = LoggerFactory.getLogger(CounterController.class);
  }




  @GetMapping("/api/test")
  ApiResponse test(){
    return ApiResponse.ok("测试");
  }
  @GetMapping("/api/put")
  public String validate(String signature,String timestamp,String nonce,String echostr){
    // 1. 将token、timestamp、nonce三个参数进行字典序排序
    String[] arr = {timestamp, nonce, TOKEN};
    Arrays.sort(arr);
    // 2. 将三个参数字符串拼接成一个字符串进行sha1加密
    StringBuilder sb = new StringBuilder();
    for (String temp : arr) {
      sb.append(temp);
    }
    // 这里利用了hutool的加密工具类
    String sha1 = SecureUtil.sha1(sb.toString());
    // 3. 加密后的字符串与signature对比，如果相同则该请求来源于微信，原样返回echostr
    if (sha1.equals(signature)){
      return echostr;
    }
    // 接入失败
    return null;
  }
  @PostMapping(value = "/api/put",produces = MediaType.APPLICATION_XML_VALUE)
  @ResponseBody
  String getGZH(@RequestBody PublicRequest request){
    logger.info("-----------------测试接收到消息 Start----------------");
    logger.info("api/put post PublicRequest, action:{}",request);
    logger.info("-----------------测试接收到消息 End----------------");
    String xml = "";
    String studentName =request.getContent();
    if (Strings.isEmpty(studentName)) {
      xml ="<xml>\n" +
              "  <ToUserName><![CDATA["+request.getFromUserName()+"]]></ToUserName>\n" +
              "  <FromUserName><![CDATA["+request.getToUserName()+"]]></FromUserName>\n" +
              "  <CreateTime>"+request.getCreateTime()+"</CreateTime>\n" +
              "  <MsgType><![CDATA[text]]></MsgType>\n" +
              "  <Content><![CDATA[未找到 {"+studentName+"} 同学的信息。]]></Content>\n" +
              "</xml>";
      return xml;
    }

    try {
      Root student = FeiShuAPI.getStudent(request.getContent().trim());
      JsonRootBean allFeiShuStudent = FeiShuAPI.getAllFeiShuStudent(studentName);
      String imageURL = FeiShuAPI.getImageURL(allFeiShuStudent.getData().getItems().get(0).getFields().get照片().get(0).getFile_token());
      Fields fields = allFeiShuStudent.getData().getItems().get(0).getFields();
      String tname = "无";
      if (student.getData().getItems().get(0).getFields().get技术指导老师()!=null){
        tname=student.getData().getItems().get(0).getFields().get技术指导老师().get(0).getText();
      }
      String jyName = "无";
      if (student.getData().getItems().get(0).getFields().get分配就业组()!=null){
        jyName=student.getData().getItems().get(0).getFields().get分配就业组();
      }
      String status = student.getData().getItems().get(0).getFields().get学员状态().get(0).getText();
      xml ="<xml>\n" +
              "  <ToUserName><![CDATA["+request.getFromUserName()+"]]></ToUserName>\n" +
              "  <FromUserName><![CDATA["+request.getToUserName()+"]]></FromUserName>\n" +
              "  <CreateTime>"+request.getCreateTime()+"</CreateTime>\n" +
              "  <MsgType><![CDATA[news]]></MsgType>\n" +
              "<ArticleCount>1</ArticleCount>"+
              "<Articles>\n" +
              "    <item>\n" +
              "      <Title><![CDATA["+fields.get学生姓名()+"->"+student.getData().getItems().get(0).getFields().get学校().get(0).getText()+" 状态:"+status+"]]></Title>\n" +
              "      <Description><![CDATA["+
              //            "学员状态 :"+student.getData().getItems().get(0).getFields().get学员状态().get(0).getText()+" "
              "班主任 : "+student.getData().getItems().get(0).getFields().get班主任()+""
              +" 就业组 : "+jyName+""
              +" 教学老师 : "+tname+""
              +" 渠道经理 : "+student.getData().getItems().get(0).getFields().get渠道经理().get(0).getText()
              +
              "]]></Description>\n" +
              "      <PicUrl><![CDATA["+imageURL+"]]></PicUrl>\n" +
              "      <Url><![CDATA[https://lanqiao.retool.com/embedded/public/1012982e-e203-47d3-bcfe-dbe1bf89bceb#phone="+allFeiShuStudent.getData().getItems().get(0).getFields().get联系电话()+"]]></Url>\n" +
              "    </item>\n" +
              "  </Articles>"+
              //            "  <Content><![CDATA["+student.getData().getItems().get(0).getFields().get班主任()+"：服务器回复给你的！]]></Content>\n" +
              "</xml>";
    } catch (Exception e) {
//      e.printStackTrace();
      xml ="<xml>\n" +
              "  <ToUserName><![CDATA["+request.getFromUserName()+"]]></ToUserName>\n" +
              "  <FromUserName><![CDATA["+request.getToUserName()+"]]></FromUserName>\n" +
              "  <CreateTime>"+request.getCreateTime()+"</CreateTime>\n" +
              "  <MsgType><![CDATA[text]]></MsgType>\n" +
              "  <Content><![CDATA[未找到 {"+studentName+"} 同学的信息。]]></Content>\n" +
              "</xml>";
      logger.error("处理响应XML数据错误，飞书异常 {}",e);
    }
    return xml;
  }

}