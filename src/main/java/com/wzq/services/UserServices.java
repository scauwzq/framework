package com.wzq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzq.dao.UserMapper;
import com.wzq.model.User;

@Service
public class UserServices {
  @Autowired
  UserMapper userMapper;

  public User findUser(Long id) {
    User user = userMapper.selectByPrimaryKey(id);
    return user;
  }
}
