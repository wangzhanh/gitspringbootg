package com.example.test.service.impl;

import com.example.test.entity.UserLogin;
import com.example.test.mapper.UserLoginDao;
import com.example.test.service.UserLoginService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * (UserLogin)表服务实现类
 *
 * @author makejava
 * @since 2022-05-13 19:18:28
 */
@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    private UserLoginDao userLoginDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserLogin queryById(Long id) {
        return userLoginDao.queryById(id);
    }

    /**
     * 不分页查询
     *
     * @param userLogin 筛选条件
     * @return 查询结果
     */
    public List<UserLogin> queryAll(UserLogin userLogin) {
        return userLoginDao.queryAll(userLogin);
    }

    /**
     * 新增数据
     *
     * @param userLogin 实例对象
     * @return 是否成功 成功：1 失败：0
     */
    @Override
    public int insert(UserLogin userLogin) {
        return userLoginDao.insert(userLogin);
    }

    /**
     * 修改数据
     *
     * @param userLogin 实例对象
     * @return 是否成功 成功：1 失败：0
     */
    @Override
    public int update(UserLogin userLogin) {
        return userLoginDao.update(userLogin);
    }

}
