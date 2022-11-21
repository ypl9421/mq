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
public class 学员信息表附件 {

    private String file_token;
    private String name;
    private int size;
    private String tmp_url;
    private String type;
    private String url;
    public void setFile_token(String file_token) {
         this.file_token = file_token;
     }
     public String getFile_token() {
         return file_token;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setSize(int size) {
         this.size = size;
     }
     public int getSize() {
         return size;
     }

    public void setTmp_url(String tmp_url) {
         this.tmp_url = tmp_url;
     }
     public String getTmp_url() {
         return tmp_url;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

}