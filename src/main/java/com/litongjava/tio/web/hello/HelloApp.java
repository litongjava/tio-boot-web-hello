package com.litongjava.tio.web.hello;

import com.litongjava.tio.boot.TioApplication;
import com.litongjava.tio.web.hello.config.WebHelloConfig;

public class HelloApp {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    TioApplication.run(HelloApp.class, new WebHelloConfig(), args);
    long end = System.currentTimeMillis();
    System.out.println((end - start) + "ms");
  }
}
