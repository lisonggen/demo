package com.example.demo.service;

import com.example.demo.bean.ClkUser;
import org.springframework.stereotype.Service;

public interface UserService {
    public ClkUser selectByUserId(Long userId);

    public int saveUser(ClkUser user);
}
