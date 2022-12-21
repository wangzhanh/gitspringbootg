package com.example.test.service.impl;

import com.example.common.enums.MessageHandlerEnum;
import com.example.test.entity.MessageEntity;
import com.example.test.service.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/5/26 18:06
 * @desc
 */
@Component
@Slf4j
public class LoginMessageHandler implements MessageHandler{
    @Override
    public boolean accept(MessageEntity messageEntity) {
        if(Objects.isNull(messageEntity)){
            return false;
        }
        return messageEntity.getType()== MessageHandlerEnum.LOGIN.getCode();
    }

    @Override
    public void process(MessageEntity messageEntity) {
        log.info("LoginMessageHandler-process={}",messageEntity.getMessage());
    }
}
