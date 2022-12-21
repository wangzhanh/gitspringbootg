package com.example.test.service;

import com.example.test.entity.MessageEntity;

/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/5/26 18:03
 * @desc
 */
public interface MessageHandler {
    boolean accept(MessageEntity messageEntity);

    void process(MessageEntity messageEntity);
}
