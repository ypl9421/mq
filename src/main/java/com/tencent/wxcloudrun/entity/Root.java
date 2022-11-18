package com.tencent.wxcloudrun.entity;

/**
 * @author 无语
 * @create 2022-11-18 15:41
 */
@lombok.Data
public class Root
{
    private int code;

    private Data data;

    private String msg;

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
}