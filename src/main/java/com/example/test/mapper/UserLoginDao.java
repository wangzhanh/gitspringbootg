package com.example.test.mapper;

import com.example.test.entity.UserLogin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (UserLogin)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-13 19:18:26
 */
@Mapper
public interface UserLoginDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserLogin queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param userLogin 查询条件
     * @return 对象列表
     */
    List<UserLogin> queryAll(UserLogin userLogin);

    /**
     * 统计总行数
     *
     * @param userLogin 查询条件
     * @return 总行数
     */
    long count(UserLogin userLogin);

    /**
     * 新增数据
     *
     * @param userLogin 实例对象
     * @return 影响行数
     */
    int insert(UserLogin userLogin);

    /**
     * 修改数据
     *
     * @param userLogin 实例对象
     * @return 影响行数
     */
    int update(UserLogin userLogin);


}

