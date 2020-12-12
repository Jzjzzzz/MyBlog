package com.jzj.blog.service;

import com.jzj.blog.po.User;

public interface UserService {
    User checkUser(String username,String password);
}
