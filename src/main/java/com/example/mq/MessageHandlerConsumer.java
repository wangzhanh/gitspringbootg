package com.example.mq;

import com.alibaba.fastjson.JSON;
import com.example.test.entity.MessageEntity;
import com.example.test.service.MessageHandler;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/5/26 18:32
 * @desc
 */
@Service
@Slf4j
public class MessageHandlerConsumer implements ApplicationContextAware, InitializingBean {

    public static ApplicationContext context = null;

    public static List<MessageHandler> processHandlers = Lists.newArrayList();

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, MessageHandler> beansOfType = context.getBeansOfType(MessageHandler.class);
        processHandlers.addAll(beansOfType.values());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
    public  void process(String message){
      log.info("MessageHandlerConsumer message:{}",message);
      MessageEntity messageEntity;
      try{
          messageEntity = JSON.parseObject(message, MessageEntity.class);
      }catch (Exception e){
          log.error("非标准格式消息");
          return;
      }

      for(MessageHandler handler : processHandlers){
          if (handler.accept(messageEntity)){
              handler.process(messageEntity);
          }
      }
    }
}
