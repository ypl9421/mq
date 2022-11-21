package org.lq.test;


import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 无语
 * @create 2022-11-14 16:19
 */
public class FeiShu {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("app_id","cli_a253bf5720f8d013");
        map.put("app_secret","XzUL5WpTpnGIVEI9MqtnOe8zdsOg1rc6");
//        map.put("app_id","cli_a3bfb882937b500c");
//        map.put("app_secret","rORKSmHr8yVFvahOwfA47eLAvg8Ugipu");

        String s = JSONUtil.toJsonStr(map);
        System.out.println(s);
        // 默认配置为自建应用
        HttpResponse execute = HttpUtil.createPost("https://open.feishu.cn/open-apis/auth/v3/app_access_token/internal")
                .header("Content-Type", "application/json; charset=utf-8")
                .body(s)
                .execute();
        String body = execute.body();
        System.out.println("body = " + body);
        JSONObject jsonObject = JSONUtil.parseObj(body);
        Object app_access_token = jsonObject.get("app_access_token");

        //c7dp0c0ca7874ba8b46d7c4357867194
        String redirect_uri="https://lanqiao-courses.feishu.cn/base/bascn7LR8OmgipwDqWyu3Mu3jtf?table=tblDojNsFWBjCYC7&view=vewXrZFoyG";
        String url = "https://open.feishu.cn/open-apis/authen/v1/index?redirect_uri="+redirect_uri+"&app_id=cli_a253bf5720f8d013&state=wuyu";
        System.out.println(url);
//        String s1 = HttpUtil.get(url);
//        System.out.println(s1);

//        String url = "https://open.feishu.cn/open-apis/mina/v2/tokenLoginValidate";
//        HttpResponse authorization = HttpUtil.createPost(url)
//                .header("Content-Type", "application/json; charset=utf-8")
//                .header("Authorization", "Bearer " + app_access_token)
//                .execute();



//        Map<String, String> user_body = new HashMap<>();
//        user_body.put("grant_type","authorization_code");
//        user_body.put("code","xMSldislSkdK");
//        System.out.println("JSONUtil.toJsonStr(user_body) = " + JSONUtil.toJsonStr(user_body));
//        String body1 = HttpUtil.createPost("https://open.feishu.cn/open-apis/authen/v1/access_token")
//                .header("Authorization", "Bearer t-g104bhjhO62ZWRWWSCMTVBIQUBE42QGPQBD2E7GG")
//                .header("Content-Type", "application/json; charset=utf-8")
//                .body(JSONUtil.toJsonStr(user_body))
//                .execute().body();
//
//        System.out.println(body1);

        //https://open.feishu.cn/open-apis/authen/v1/index?redirect_uri=https://open.feishu.cn/api-explorer/cli_a253bf5720f8d013&app_id=cli_a253bf5720f8d013&state=wuyu
        //https://open.feishu.cn/open-apis/authen/v1/index?app_id=cli_9dff7f6ae02ad104&redirect_uri=https%3a%2f%2fopen.feishu.cn%2fdocument%2fuQjL04CN%2fucDOz4yN4MjL3gzM&state=RANDOMSTATE

    }

}
