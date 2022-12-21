package com.example.test.controller;

import com.example.test.entity.UserLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 展示层
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/12/9 18:12
 * @desc
 */
@Controller
@Slf4j
@RequestMapping("/modelController")
public class ModelController {

    @GetMapping(value = "/skipShow")
    public String skipShow(Model model, @RequestParam(value = "userName", required = true) String userName) {
        log.info("userName={}",userName);
        model.addAttribute("userName", userName);
        UserLogin userLogin = new UserLogin(1L,"赵六","123");
        model.addAttribute("userLogin",userLogin);
        return "/show";
    }
}
