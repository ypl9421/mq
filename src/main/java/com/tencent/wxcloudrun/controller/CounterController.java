package com.tencent.wxcloudrun.controller;

import cn.hutool.crypto.SecureUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.tencent.wxcloudrun.dto.PublicRequest;
import com.tencent.wxcloudrun.dto.ReturnResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
  @PostMapping(value = "api/put",produces = MediaType.APPLICATION_XML_VALUE)
  @ResponseBody
  String getGZH(@RequestBody PublicRequest request){
    logger.info("-----------------测试接收到消息 Start----------------");
    logger.info("api/put post PublicRequest, action:{}",request);
    logger.info("-----------------测试接收到消息 End----------------");
    String xml ="<xml>\n" +
            "  <ToUserName><![CDATA["+request.getFromUserName()+"]]></ToUserName>\n" +
            "  <FromUserName><![CDATA["+request.getToUserName()+"]]></FromUserName>\n" +
            "  <CreateTime>"+request.getCreateTime()
            +"</CreateTime>\n" +
            "  <MsgType><![CDATA[text]]></MsgType>\n" +
            "  <Content><![CDATA["+request.getContent()+"：服务器回复给你的！]]></Content>\n" +
            "</xml>";
    return xml;
  }

}