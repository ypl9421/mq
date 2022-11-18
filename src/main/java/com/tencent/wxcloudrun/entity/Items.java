package com.tencent.wxcloudrun.entity;

import lombok.Data;

/**
 * @author 无语
 * @create 2022-11-18 15:40
 */
@Data
public class Items
{
    private Fields fields;

    private String id;

    private String record_id;

    public void setFields(Fields fields){
        this.fields = fields;
    }
    public Fields getFields(){
        return this.fields;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setRecord_id(String record_id){
        this.record_id = record_id;
    }
    public String getRecord_id(){
        return this.record_id;
    }
}