package com.litongjava.tio.web.hello.config;

import com.litongjava.context.BootConfiguration;
import com.litongjava.tio.boot.server.TioBootServer;
import com.litongjava.tio.http.server.router.HttpRequestRouter;
import com.litongjava.tio.web.hello.handler.HelloHandler;

public class WebHelloConfig implements BootConfiguration {

  public void config() {

    TioBootServer server = TioBootServer.me();
    HttpRequestRouter requestRouter = server.getRequestRouter();

    HelloHandler helloHandler = new HelloHandler();
    requestRouter.add("/", helloHandler);

  }
}
