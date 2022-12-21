package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/5/26 18:05
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {
    private int type;
    private String message;
}
