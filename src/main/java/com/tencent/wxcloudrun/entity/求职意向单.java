package com.tencent.wxcloudrun.entity;

/**
 * @author 无语
 * @create 2022-11-18 15:40
 */
public class 求职意向单
{
    private String text;

    private String type;

    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}