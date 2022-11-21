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
public class 学员云课主页 {

    private String link;
    private String text;
    private String type;
    public void setLink(String link) {
         this.link = link;
     }
     public String getLink() {
         return link;
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