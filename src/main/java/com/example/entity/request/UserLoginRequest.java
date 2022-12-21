package com.example.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * UserLoginRequest
 *
 * @author makejava
 * @since 2022-05-13 19:18:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;


}

