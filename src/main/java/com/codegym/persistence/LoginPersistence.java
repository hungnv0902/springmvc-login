package com.codegym.persistence;

import com.codegym.model.User;

public interface LoginPersistence<E> {
    User checkLogin(E e);
}