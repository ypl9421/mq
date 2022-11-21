/**
  * Copyright 2022 bejson.com 
  */
package com.tencent.wxcloudrun.pojo;

import lombok.Data;

/**
 * Auto-generated: 2022-11-19 0:36:3
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Items {

    private Fields fields;
    private String id;
    private String record_id;
    public void setFields(Fields fields) {
         this.fields = fields;
     }
     public Fields getFields() {
         return fields;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setRecord_id(String record_id) {
         this.record_id = record_id;
     }
     public String getRecord_id() {
         return record_id;
     }

}