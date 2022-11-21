package org.lq.test;

import cn.hutool.core.util.XmlUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.tencent.wxcloudrun.dto.ReturnResponse;

import java.io.Serializable;

/**
 * @author 无语
 * @create 2022-11-14 15:30
 */
public class XMLDemo {
    public static void main(String[] args) {
        ReturnResponse rs = new ReturnResponse();
        rs.setToUserName("test");
        rs.setFromUserName("ww");
        rs.setCreateTime(System.currentTimeMillis());
        rs.setContent("测试666");
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String s = xmlMapper.writeValueAsString(rs);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
