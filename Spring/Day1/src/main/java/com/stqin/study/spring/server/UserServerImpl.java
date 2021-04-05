package com.stqin.study.spring.server;

import com.stqin.study.spring.dao.UserDao;

public class UserServerImpl implements UserServer {
    private UserDao userDao;
    public void setDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getName() {
        userDao.getName();
    }
}
