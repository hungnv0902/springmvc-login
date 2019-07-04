package com.codegym.persistence;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginPersistenceImpl implements LoginPersistence<Login>{
    List<User> loginDao = new ArrayList<>();
    {
        loginDao.add(new User("admin", "1234", "hung", "hungnv@gamil.com", 27));
    }

    @Override
    public User checkLogin(Login login) {
        for (User user: loginDao) {
            if (user.getAccount().equals(login.getUser()) &&
                user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
