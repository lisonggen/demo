package com.example.demo.service.impl;

import com.example.demo.bean.ClkUser;
import com.example.demo.mapper.ClkUserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private ClkUserMapper clkUserMapper;

    @Override
    public ClkUser selectByUserId(Long userId) {
        return clkUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int saveUser(ClkUser user) {
        return clkUserMapper.insert(user);
    }
}
