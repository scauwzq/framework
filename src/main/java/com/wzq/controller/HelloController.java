package com.wzq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wzq.model.User;
import com.wzq.services.UserServices;

@Controller
public class HelloController {
  @Autowired
  UserServices userServices;
  @RequestMapping("/")
  public String index() {
    Long id = 14l;
    User user = userServices.findUser(id);
    System.out.println(user.getUserName());
    return "index";
  }
}
