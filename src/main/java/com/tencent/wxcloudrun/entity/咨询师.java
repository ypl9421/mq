package com.tencent.wxcloudrun.entity;

/**
 * @author 无语
 * @create 2022-11-18 15:38
 */
import java.util.ArrayList;
import java.util.List;
public class 咨询师
{
    private List<String> record_ids;

    private String table_id;

    private String text;

    private String type;

    public void setRecord_ids(List<String> record_ids){
        this.record_ids = record_ids;
    }
    public List<String> getRecord_ids(){
        return this.record_ids;
    }
    public void setTable_id(String table_id){
        this.table_id = table_id;
    }
    public String getTable_id(){
        return this.table_id;
    }
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

