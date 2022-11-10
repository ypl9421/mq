package com.tencent.wxcloudrun.dto;

import lombok.Data;

/**
 * @author 无语
 * @create 2022-11-10 15:54
 */
@Data
public class PublicRequest {
    private String ToUserName;
    private String FromUserName;
    private Integer CreateTime;
    private String MsgType;
    private String Content;
    private String MsgId;






}
