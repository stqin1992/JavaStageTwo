package com.stqin.study.spring.server;

import com.stqin.study.spring.dao.UserDao;

public interface UserServer {
    void setDao(UserDao userDao);
    void getName();
}
