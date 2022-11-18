package com.tencent.wxcloudrun.entity;

/**
 * @author 无语
 * @create 2022-11-18 15:41
 */
import java.util.ArrayList;
import java.util.List;
@lombok.Data
public class Data
{
    private boolean has_more;

    private List<Items> items;

    private String page_token;

    private int total;

    public void setHas_more(boolean has_more){
        this.has_more = has_more;
    }
    public boolean getHas_more(){
        return this.has_more;
    }
    public void setItems(List<Items> items){
        this.items = items;
    }
    public List<Items> getItems(){
        return this.items;
    }
    public void setPage_token(String page_token){
        this.page_token = page_token;
    }
    public String getPage_token(){
        return this.page_token;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return this.total;
    }
}