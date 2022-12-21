package com.example.test.controller;

import com.example.entity.request.UserLoginRequest;
import com.example.entity.response.BaseResponse;
import com.example.common.enums.ApiStatusEnum;
import com.example.mq.MessageHandlerConsumer;
import com.example.test.entity.UserLogin;
import com.example.test.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * (UserLogin) 用户
 *
 * @author makejava
 * @since 2022-05-13 19:18:24
 */
@RestController
@Slf4j
@RequestMapping("/userLogin")
public class UserLoginController {
    /**
     * 服务对象
     */
    @Resource
    private UserLoginService userLoginService;

    /**
     * 新增数据
     *
     * @param userLogin 实体
     * @return 新增是否成功
     */
    @PostMapping(value = "/add")
    public BaseResponse add(@RequestBody UserLogin userLogin) {
        try{
            return BaseResponse.build(userLoginService.insert(userLogin));
        }catch (Exception e){
            log.error("新增失败",e);
            return BaseResponse.build(ApiStatusEnum.DEFAULT.getCode(), e.getMessage());
        }
    }


    @PostMapping(value = "/queryAll")
    public BaseResponse queryAll(@RequestBody UserLoginRequest userLoginRequest) {
        try{
            UserLogin userLogin = new UserLogin();
            BeanUtils.copyProperties(userLoginRequest, userLogin);
            return BaseResponse.build(userLoginService.queryAll(userLogin));
        }catch (Exception e){
            log.error("新增失败",e);
            return BaseResponse.build(ApiStatusEnum.DEFAULT.getCode(), e.getMessage());
        }
    }



    @GetMapping(value = "/test")
    @ResponseBody
    public BaseResponse test() throws Exception{
        MessageHandlerConsumer consumer = new MessageHandlerConsumer();
        consumer.process("{\"type\":2,\"message\":\"object\"}");
        return BaseResponse.build();
    }
}

