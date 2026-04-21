package com.litongjava.tio.web.hello;

import com.litongjava.tio.web.hello.config.WebHelloConfig;

import nexus.io.tio.boot.TioApplication;

public class HelloApp {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    //TioApplicationWrapper.run(HelloApp.class, args);
    TioApplication.run(HelloApp.class, new WebHelloConfig(), args);
    long end = System.currentTimeMillis();
    System.out.println((end - start) + "ms");
  }
}