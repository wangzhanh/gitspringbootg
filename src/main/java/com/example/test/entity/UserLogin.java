package com.example.test.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (UserLogin)实体类
 *
 * @author makejava
 * @since 2022-05-13 19:18:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin implements Serializable {
    private static final long serialVersionUID = 789894525552881549L;
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

