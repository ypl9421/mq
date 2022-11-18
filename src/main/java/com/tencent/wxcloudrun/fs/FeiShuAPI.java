package com.tencent.wxcloudrun.fs;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.lark.oapi.okhttp.*;
import com.tencent.wxcloudrun.controller.CounterController;
import com.tencent.wxcloudrun.entity.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author 无语
 * @create 2022-11-18 14:18
 */
public class FeiShuAPI {

    private static final String APP_ID="cli_a253bf5720f8d013";
    private static final String APP_SECRET="XzUL5WpTpnGIVEI9MqtnOe8zdsOg1rc6";
    private static LocalDateTime expire_end=LocalDateTimeUtil.now();
    private static String tenant_access_token=null;
    static final Logger logger;
    static {
        logger = LoggerFactory.getLogger(FeiShuAPI.class);
    }
    public FeiShuAPI(){
    }

    public static String getTenantAccessToken(){

        System.out.println("expire_end = " + expire_end);
        long minutes = LocalDateTimeUtil.between(LocalDateTimeUtil.now(), expire_end).toMinutes();
        System.out.println("minutes = " + minutes);
//        if (minutes>0){
//            return tenant_access_token;
//        }
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"app_id\":\""+APP_ID+"\",\"app_secret\":\""+APP_SECRET+"\"}");
        Request request = new Request.Builder()
                .url("https://open.feishu.cn/open-apis/auth/v3/tenant_access_token/internal")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response=null;
        try {
            response = client.newCall(request).execute();
//            System.out.println("response.body() = " + response.body().string());
            JSONObject jsonObject = JSONUtil.parseObj(response.body().string());
//            System.out.println(jsonObject);
            logger.info("获取Tonken ： "+jsonObject);
            //失效时间，默认是秒
            Integer expire = Integer.parseInt(jsonObject.get("expire")+"")-120;
            expire_end = LocalDateTimeUtil.offset(LocalDateTime.now(), expire, ChronoUnit.SECONDS);
            tenant_access_token = jsonObject.get("tenant_access_token")+"";
//            System.out.println("tenant_access_token = " + tenant_access_token);
            logger.info("tenant_access_token = " + tenant_access_token);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

//            if(response!=null&&response.isSuccessful()) {
//                response.close();
//            }
        }
        return tenant_access_token;
    }


    public static Root getStudent(String name){
        Root root = null;
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("");
        Request request = new Request.Builder()
                .url("https://open.feishu.cn/open-apis/bitable/v1/apps/bascn7LR8OmgipwDqWyu3Mu3jtf/tables/tblDojNsFWBjCYC7/records?filter=CurrentValue.%5B%E5%AD%A6%E7%94%9F%E5%A7%93%E5%90%8D%5D+%3D+%22"+name+"%22&page_size=20&view_id=vewXrZFoyG")
                .method("GET", null)
                .addHeader("Authorization", "Bearer "+getTenantAccessToken())
                .build();
        try {
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            root = JSONUtil.toBean(json, Root.class);
//            System.out.println(root);
            logger.info("查询学生对象 {}",root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }



    public static void main(String[] args) {
//        getStudent("李园杰");
//        getStudent("赵磊");
//        getStudent("罗鸣");
    }
}
