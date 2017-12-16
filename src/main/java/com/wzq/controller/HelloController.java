package com.wzq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.whalin.MemCached.MemCachedClient;
import com.wzq.model.User;
import com.wzq.services.UserServices;

@Controller
public class HelloController {
  @Autowired
  UserServices userServices;
  @Autowired
  MemCachedClient memCachedClient;

  @RequestMapping("/cacheSave")
  public String cacheSave(
      @RequestParam(value = "id", required = false, defaultValue = "228") String id) {
    boolean i = memCachedClient.set("id", id, 1000);
    return String.valueOf(i);
  }
  @RequestMapping("/")
  public String index() {
    Long id = 14l;
    User user = userServices.findUser(id);
    System.out.println(user.getUserName());
    return "index";
  }
}
