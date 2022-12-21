package com.example.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/11/1 23:44
 * @desc
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Node {

    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private List<Node> children;

    public Node(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
