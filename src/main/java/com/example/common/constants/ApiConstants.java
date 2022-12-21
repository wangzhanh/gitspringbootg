package com.example.common.constants;

/**
 * @author fanyuepan
 */
public final class ApiConstants {

    /**
     * 全局上下文请求参数
     * */
    public static final String CONTEXT_ATTRIBUTE_REQUEST_BODY = "business_request_body";
    /**
     * 全局上下文请求 AppId
     * */
    public static final String CONTEXT_ATTRIBUTE_REQUEST_APP_ID = "business_request_app_id";

    /**
     * 请求序列号
     * */
    public static final String CONTEXT_ATTRIBUTE_REQUEST_SERIAL_NO = "business_request_serial_no";


    /**
     * 接口固定参数名：三方标识
     * */
    public static final String PARAMETER_INSURANCE_COMPANY_ID = "inscompanyId";
    /**
     * 接口固定参数名：请求体
     * */
    public static final String PARAMETER_INSURANCE_CONTENT = "content";

    //客户历史购买记录list接口
    public static final String TELEMARKETING_USER_BUYLIST = "didi.insurance.telemarketing.user.buylist";
    //获取外链接口
    public static final String TELEMARKETING_USER_URL = "didi.insurance.telemarketing.user.url";
    //订单list接口
    public static final String TELEMARKETING_PAYORDER_LIST = "didi.insurance.telemarketing.payorder.list";
    //订单详情接口
    public static final String TELEMARKETING_PAYORDER_DETAIL = "didi.insurance.telemarketing.payorder.detail";
    //发送短信接口
    public static final String TELEMARKETING_SMS_SEND = "didi.insurance.telemarketing.user.sms.send";
}
