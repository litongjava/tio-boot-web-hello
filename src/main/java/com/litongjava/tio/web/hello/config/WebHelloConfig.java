package com.litongjava.tio.web.hello.config;

import java.io.IOException;

import com.litongjava.tio.boot.context.TioBootConfiguration;
import com.litongjava.tio.boot.server.TioBootServer;
import com.litongjava.tio.http.server.router.HttpReqeustSimpleHandlerRoute;
import com.litongjava.tio.web.hello.handler.HelloHandler;

public class WebHelloConfig implements TioBootConfiguration {

  @Override
  public void config() throws IOException {
    HelloHandler helloHandler = new HelloHandler();

    HttpReqeustSimpleHandlerRoute r = TioBootServer.me().getHttpReqeustSimpleHandlerRoute();
    r.add("/hello", helloHandler::hello);
  }

}
