package com.litongjava.tio.web.hello.config;

import com.litongjava.tio.web.hello.handler.HelloHandler;

import nexus.io.context.BootConfiguration;
import nexus.io.tio.boot.server.TioBootServer;
import nexus.io.tio.http.server.router.HttpRequestRouter;

public class WebHelloConfig implements BootConfiguration {

  public void config() {

    TioBootServer server = TioBootServer.me();
    HttpRequestRouter requestRouter = server.getRequestRouter();

    HelloHandler helloHandler = new HelloHandler();
    requestRouter.add("/", helloHandler);

  }
}
