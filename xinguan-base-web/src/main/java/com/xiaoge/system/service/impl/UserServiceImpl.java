package com.xiaoge.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoge.handler.BusinessException;
import com.xiaoge.response.ResultCode;
import com.xiaoge.system.entity.Department;
import com.xiaoge.system.entity.User;
import com.xiaoge.system.enums.UserStatusEnum;
import com.xiaoge.system.enums.UserTypeEnum;
import com.xiaoge.system.mapper.DepartmentMapper;
import com.xiaoge.system.mapper.UserMapper;
import com.xiaoge.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;


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
    private PasswordEncoder passwordEncoder;


    @Override
    public IPage<User> findUserPage(Page<User> page, QueryWrapper<User> wrapper) {
        return this.baseMapper.findUserPage(page,wrapper);
    }

    @Override
    public void addUser(User user) {
        String username = user.getUsername();
        Long departmentId = user.getDepartmentId();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Integer count = this.baseMapper.selectCount(wrapper);
        if (count != 0){
            throw new BusinessException(ResultCode.USER_ACCOUNT_ALREADY_EXIST.getCode(),ResultCode.USER_ACCOUNT_ALREADY_EXIST.getMessage());
        }
        Department department = departmentMapper.selectById(departmentId);
        if (department == null){
            throw new BusinessException(ResultCode.DEPARTMENT_NOT_EXIST.getCode(),ResultCode.DEPARTMENT_ALREADY_EXIST.getMessage());
        }

        String salt = UUID.randomUUID().toString().substring(0, 32);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setModifiedTime(new Date());
        user.setCreateTime(new Date());

        user.setSalt(salt);
        user.setStatus(UserTypeEnum.SYSTEM_USER.getTypeCode());

        user.setStatus(UserStatusEnum.AVAILABLE.getStatusCode());
        this.baseMapper.insert(user);
    }


}
