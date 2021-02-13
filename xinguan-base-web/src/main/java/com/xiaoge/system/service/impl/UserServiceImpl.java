package com.xiaoge.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoge.system.entity.User;
import com.xiaoge.system.mapper.DepartmentMapper;
import com.xiaoge.system.mapper.UserMapper;
import com.xiaoge.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xiaoge
 * @since 2020-09-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private UserMapper userMapper;



    @Override
    public IPage<User> findUserPage(Page<User> page, QueryWrapper<User> wrapper) {
        return this.baseMapper.findUserPage(page,wrapper);
    }


}
