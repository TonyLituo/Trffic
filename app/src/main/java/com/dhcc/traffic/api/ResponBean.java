package com.dhcc.traffic.api;

/**
 * Created by Lituo on 2017/4/13 0013. 11:47 .
 * Mail：tony1994_vip@163.com
 * 网络访问响应的实体
 * <p>
 * <p>
 * <p>
 * 数据请求结果统一预处理实体类（要求服务器返回数据统一格式）
 * 如数据格式为：
 * <p>
 * {
 * "rtnCode": 0,
 * "RtnMsg": "成功",
 * "ResParams": {}
 * }
 */

public abstract class ResponBean {


    /**
     * resParams :
     * rtnCode : 0000
     * rtnMsg : 交易成功
     */

    protected String rtnCode;

    protected String rtnMsg;


    public String getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getRtnMsg() {
        return rtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }

    @Override
    public String toString() {
        return "ResponBean{" +
                "rtnCode='" + rtnCode + '\'' +
                ", rtnMsg='" + rtnMsg + '\'' +
                '}';
    }
}
