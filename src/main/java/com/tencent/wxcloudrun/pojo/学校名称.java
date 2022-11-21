/**
  * Copyright 2022 bejson.com 
  */
package com.tencent.wxcloudrun.pojo;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2022-11-19 0:36:3
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class 学校名称 {

    private List<String> record_ids;
    private String table_id;
    private String text;
    private String type;
    public void setRecord_ids(List<String> record_ids) {
         this.record_ids = record_ids;
     }
     public List<String> getRecord_ids() {
         return record_ids;
     }

    public void setTable_id(String table_id) {
         this.table_id = table_id;
     }
     public String getTable_id() {
         return table_id;
     }

    public void setText(String text) {
         this.text = text;
     }
     public String getText() {
         return text;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

}