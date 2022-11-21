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
public class 蓝桥推荐报告 {

    private String file_token;
    private String name;
    private long size;
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

    public void setSize(long size) {
         this.size = size;
     }
     public long getSize() {
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