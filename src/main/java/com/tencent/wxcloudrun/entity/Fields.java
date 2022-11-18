package com.tencent.wxcloudrun.entity;

/**
 * @author 无语
 * @create 2022-11-18 15:40
 */
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Fields
{
    private String 入营年级;

    private String 分配就业组;

    private List<String> 合同名称;

    private List<咨询师> 咨询师;

    private List<学员状态> 学员状态;

    private List<学校> 学校;

    private String 学生姓名;

    private String 实收金额;

    private String 就业方向;

    private List<就业服务老师> 就业服务老师;

    private String 性别;

    private List<技术指导老师> 技术指导老师;

    private int 是否结算;

    private List<求职意向单> 求职意向单;

    private List<渠道经理> 渠道经理;

    private String 班主任;

    private int 签署协议日期;

    private boolean 联系标记;

    public void set入营年级(String 入营年级){
        this.入营年级 = 入营年级;
    }
    public String get入营年级(){
        return this.入营年级;
    }
    public void set分配就业组(String 分配就业组){
        this.分配就业组 = 分配就业组;
    }
    public String get分配就业组(){
        return this.分配就业组;
    }
    public void set合同名称(List<String> 合同名称){
        this.合同名称 = 合同名称;
    }
    public List<String> get合同名称(){
        return this.合同名称;
    }
    public void set咨询师(List<咨询师> 咨询师){
        this.咨询师 = 咨询师;
    }
    public List<咨询师> get咨询师(){
        return this.咨询师;
    }
    public void set学员状态(List<学员状态> 学员状态){
        this.学员状态 = 学员状态;
    }
    public List<学员状态> get学员状态(){
        return this.学员状态;
    }
    public void set学校(List<学校> 学校){
        this.学校 = 学校;
    }
    public List<学校> get学校(){
        return this.学校;
    }
    public void set学生姓名(String 学生姓名){
        this.学生姓名 = 学生姓名;
    }
    public String get学生姓名(){
        return this.学生姓名;
    }
    public void set实收金额(String 实收金额){
        this.实收金额 = 实收金额;
    }
    public String get实收金额(){
        return this.实收金额;
    }
    public void set就业方向(String 就业方向){
        this.就业方向 = 就业方向;
    }
    public String get就业方向(){
        return this.就业方向;
    }
    public void set就业服务老师(List<就业服务老师> 就业服务老师){
        this.就业服务老师 = 就业服务老师;
    }
    public List<就业服务老师> get就业服务老师(){
        return this.就业服务老师;
    }
    public void set性别(String 性别){
        this.性别 = 性别;
    }
    public String get性别(){
        return this.性别;
    }
    public void set技术指导老师(List<技术指导老师> 技术指导老师){
        this.技术指导老师 = 技术指导老师;
    }
    public List<技术指导老师> get技术指导老师(){
        return this.技术指导老师;
    }
    public void set是否结算(int 是否结算){
        this.是否结算 = 是否结算;
    }
    public int get是否结算(){
        return this.是否结算;
    }
    public void set求职意向单(List<求职意向单> 求职意向单){
        this.求职意向单 = 求职意向单;
    }
    public List<求职意向单> get求职意向单(){
        return this.求职意向单;
    }
    public void set渠道经理(List<渠道经理> 渠道经理){
        this.渠道经理 = 渠道经理;
    }
    public List<渠道经理> get渠道经理(){
        return this.渠道经理;
    }
    public void set班主任(String 班主任){
        this.班主任 = 班主任;
    }
    public String get班主任(){
        return this.班主任;
    }
    public void set签署协议日期(int 签署协议日期){
        this.签署协议日期 = 签署协议日期;
    }
    public int get签署协议日期(){
        return this.签署协议日期;
    }
    public void set联系标记(boolean 联系标记){
        this.联系标记 = 联系标记;
    }
    public boolean get联系标记(){
        return this.联系标记;
    }
}