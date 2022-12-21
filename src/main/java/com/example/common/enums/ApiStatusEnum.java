package com.example.common.enums;

/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/5/13 19:41
 * @desc
 */
public enum ApiStatusEnum {

    /**
     * 成功
     */
    SUCCESS(0, "ok"),
    /**
     * 非法请求
     */
    BAD_REQUEST(400, "bad request"),
    /**
     * 非法用户
     */
    USER_NOT_FOUND(401, "该用户无法认证"),
    /**
     * 未授权
     */
    FORBIDDEN(403, "没有授权"),
    /**
     * 服务不存在
     */
    NOT_FOUND(404, "服务不存在"),
    /**
     * 请求方法不支持
     */
    METHOD_NOT_ALLOWED(405, "请求方法不支持"),
    /**
     * 第三方请求超时
     */
    REQUEST_TIMEOUT(408, "第三方请求超时"),
    /**
     * 媒体类型不支持
     */
    UNSUPPORTED_MEDIA_TYPE(415, "媒体类型不支持"),
    /**
     * 请求参数非法
     */
    INVALID_PARAMETER(412, "请求参数非法"),
    /**
     * 请求参数反序列化失败
     */
    PARAMETER_DESERIALIZE_FAIL(413, "请求参数反序列化失败"),
    /**
     * 第三方响应非法
     */
    INVALID_RESPONSE(420, "第三方响应非法"),
    /**
     * 第三方响应反序列化失败
     */
    RESPONSE_DESERIALIZE_FAIL(421, "第三方响应反序列化失败"),
    /**
     * 请求次数过多
     */
    TOO_MANY_REQUESTS(429, "请求次数过多"),
    /**
     * 代表请求应当在执行完适当的操作后进行重试
     */
    RETRY_WITH(449, "请求重试"),
    /**
     * token非法
     */
    INVALID_TOKEN(498, "token非法"),
    /**
     * 服务器内部错误,默认错误
     */
    DEFAULT(500, "服务器内部错误"),
    /**
     * 服务并发异常
     */
    CONCURRENT(501, "服务处理中,请稍后再试");
    private int code;
    private String message;

    ApiStatusEnum() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ApiStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ApiStatusEnum getByCode(int code) {
        for (ApiStatusEnum apiStatusEnum : values()) {
            if (apiStatusEnum.getCode() == code) {
                return apiStatusEnum;
            }
        }
        return null;
    }

}
