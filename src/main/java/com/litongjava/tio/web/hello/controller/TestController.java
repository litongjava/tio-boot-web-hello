package com.litongjava.tio.web.hello.controller;
import com.litongjava.annotation.AController;
import com.litongjava.annotation.RequestPath;
@AController
@RequestPath("/test")
public class TestController {

  @RequestPath
  public String index() {
    return "index";
  }
}