package com.example.common.enums;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/5/26 18:12
 * @desc
 */
public enum MessageHandlerEnum {
    LOGIN(1, "登录消息"),
    ORDER(2, "订单消息");
    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    MessageHandlerEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static List<MessageHandlerEnum> LOGIN_ORDER = Lists.newArrayList(LOGIN, ORDER);

    public MessageHandlerEnum resolve(int code) {
        for (MessageHandlerEnum handlerEnum : values()) {
            if (code == handlerEnum.getCode()) {
                return handlerEnum;
            }
        }
        throw new IllegalArgumentException("消息类型不能为:" + code);
    }
}
