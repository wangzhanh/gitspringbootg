package com.example.entity.response;

import com.example.common.enums.ApiStatusEnum;
import lombok.Data;

/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/5/13 19:30
 * @desc
 */
@Data
public class BaseResponse<T> {
    private T data;
    private int errorCode;
    private String errorMsg;

    public BaseResponse() {
        this.errorCode = ApiStatusEnum.SUCCESS.getCode();
        this.errorMsg = ApiStatusEnum.SUCCESS.getMessage();
    }

    public static <E> BaseResponse<E> build() {
        return build(ApiStatusEnum.SUCCESS.getCode(), ApiStatusEnum.SUCCESS.getMessage(), null);
    }

    public static <E> BaseResponse<E> build(E data) {
        return build(ApiStatusEnum.SUCCESS.getCode(), ApiStatusEnum.SUCCESS.getMessage(), data);
    }

    public static <E> BaseResponse<E> build(int errorCode, String errorMsg, E data) {
        BaseResponse<E> baseResponse = new BaseResponse();
        baseResponse.data = data;
        baseResponse.errorCode = errorCode;
        baseResponse.errorMsg = errorMsg;
        return baseResponse;
    }

    public static <E> BaseResponse<E> build(int errorCode, String errorMsg) {
        BaseResponse<E> baseResponse = new BaseResponse();
        baseResponse.errorCode = errorCode;
        baseResponse.errorMsg = errorMsg;
        return baseResponse;
    }
    /*public static <E> BaseResponse<E> build(Response error, Throwable throwable) {
        return build(error.getErrorCode(), ExceptionUtils.getStackTrace(throwable), null);
    }*/
}
