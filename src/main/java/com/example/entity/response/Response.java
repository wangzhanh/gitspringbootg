package com.example.entity.response;

/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/5/13 19:36
 * @desc
 */
public interface Response {

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    int getErrorCode();

    /**
     * 返回错误消息
     *
     * @return 返回错误消息
     */
    String getErrorMsg();

    /**
     * 判断是否成功
     *
     * @return 是否成功
     */
    default boolean isSuccess() {
        return getErrorCode() == 0;
    }
}