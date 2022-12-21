package com.example.test.service;

import com.example.test.entity.UserLogin;
import java.util.List;

/**
 * (UserLogin)表服务接口
 *
 * @author makejava
 * @since 2022-05-13 19:18:28
 */
public interface UserLoginService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserLogin queryById(Long id);


     /**
     * 不分页查询
     *
     * @param userLogin 筛选条件
     * @return 查询结果
     */
    List<UserLogin> queryAll(UserLogin userLogin);

    /**
     * 新增数据
     *
     * @param userLogin 实例对象
     * @return 是否成功 成功：1 失败：0
     */
    int insert(UserLogin userLogin);

    /**
     * 修改数据
     *
     * @param userLogin 实例对象
     * @return 是否成功 成功：1 失败：0
     */
    int update(UserLogin userLogin);


}

