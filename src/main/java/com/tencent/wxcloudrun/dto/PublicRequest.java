package com.tencent.wxcloudrun.dto;

import lombok.Data;

/**
 * @author 无语
 * @create 2022-11-10 15:54
 */
@Data
public class PublicRequest {
    private String toUserName;
    private String fromUserName;
    private Integer createTime;
    private String msgType;
    private String content;
    private String msgId;






}
