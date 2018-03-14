package com.joker.restful.api.impl;

import com.joker.restful.api.UserService;
import org.springframework.stereotype.Component;

/**
 * @author huangsy
 * @date 2018/1/27 13:05
 */
@Component
public class UserServiceImpl implements UserService {

    @Override
    public String get() {
        return "hello world";
    }
}
