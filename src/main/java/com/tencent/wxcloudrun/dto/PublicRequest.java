package com.tencent.wxcloudrun.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 无语
 * @create 2022-11-10 15:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@XmlRootElement(name = "xml")
//@XmlAccessorType(XmlAccessType.FIELD)
@JacksonXmlRootElement(localName = "xml")
public class PublicRequest {
    // 开发者微信号
    @JacksonXmlProperty(localName = "FromUserName")
    protected String FromUserName;
    // 发送方帐号（一个OpenID）
    @JacksonXmlProperty(localName = "ToUserName")
    protected String ToUserName;
    // 消息创建时间
    @JacksonXmlProperty(localName = "CreateTime")
    protected Long CreateTime;
    /**
     * 消息类型
     * text 文本消息
     * image 图片消息
     * voice 语音消息
     * video 视频消息
     * music 音乐消息
     */
    @JacksonXmlProperty(localName = "MsgType")
    protected String MsgType;
    // 消息id
    @JacksonXmlProperty(localName = "MsgId")
    protected Long MsgId;
    // 文本内容
    @JacksonXmlProperty(localName = "Content")
    private String Content;
    // 图片链接（由系统生成）
    @JacksonXmlProperty(localName = "PicUrl")
    private String PicUrl;
    // 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
    @JacksonXmlProperty(localName = "MediaId")
    private String MediaId;






}
