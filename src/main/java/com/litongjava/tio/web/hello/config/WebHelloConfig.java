package com.litongjava.tio.web.hello.config;

import java.io.IOException;

import com.litongjava.jfinal.aop.annotation.AConfiguration;
import com.litongjava.jfinal.aop.annotation.AInitialization;
import com.litongjava.tio.boot.context.TioBootConfiguration;
import com.litongjava.tio.boot.server.TioBootServer;
import com.litongjava.tio.http.server.router.RequestRoute;
import com.litongjava.tio.web.hello.handler.HelloHandler;

@AConfiguration
public class WebHelloConfig implements TioBootConfiguration {

  @Override
  @AInitialization
  public void config() throws IOException {
    HelloHandler helloHandler = new HelloHandler();

    RequestRoute r = TioBootServer.me().getRequestRoute();
    r.add("/hello", helloHandler::hello);
  }

}
