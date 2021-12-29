package com.zking.controller;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

  @RequestMapping("/index")
  public String goIndex(){
     return "index";
  }
}
