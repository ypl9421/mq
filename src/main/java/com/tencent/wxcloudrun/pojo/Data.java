/**
  * Copyright 2022 bejson.com 
  */
package com.tencent.wxcloudrun.pojo;
import java.util.List;

/**
 * Auto-generated: 2022-11-19 0:36:3
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@lombok.Data
public class Data {

    private boolean has_more;
    private List<Items> items;
    private String page_token;
    private int total;
    public void setHas_more(boolean has_more) {
         this.has_more = has_more;
     }
     public boolean getHas_more() {
         return has_more;
     }

    public void setItems(List<Items> items) {
         this.items = items;
     }
     public List<Items> getItems() {
         return items;
     }

    public void setPage_token(String page_token) {
         this.page_token = page_token;
     }
     public String getPage_token() {
         return page_token;
     }

    public void setTotal(int total) {
         this.total = total;
     }
     public int getTotal() {
         return total;
     }

}