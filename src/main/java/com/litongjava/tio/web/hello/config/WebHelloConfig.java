package com.litongjava.tio.web.hello.config;

import com.litongjava.annotation.AConfiguration;
import com.litongjava.annotation.Initialization;
import com.litongjava.model.type.TioTypeReference;
import com.litongjava.tio.boot.server.TioBootServer;
import com.litongjava.tio.http.server.handler.IHttpRequestFunction;
import com.litongjava.tio.http.server.router.HttpRequestFunctionRouter;
import com.litongjava.tio.http.server.router.HttpRequestRouter;
import com.litongjava.tio.web.hello.handler.HelloHandler;

@AConfiguration
public class WebHelloConfig {

  @Initialization
  public void config() {

    TioBootServer server = TioBootServer.me();
    HttpRequestRouter requestRouter = server.getRequestRouter();

    HelloHandler helloHandler = new HelloHandler();
    requestRouter.add("/ok", helloHandler::ok);

    HttpRequestFunctionRouter requestFunctionRouter = server.getRequestFunctionRouter();
    // 添加路由函数时使用 TioTypeReference 捕获泛型类型
    requestFunctionRouter.add("/string", new IHttpRequestFunction<String, String>() {
      @Override
      public String handle(String t) throws Exception {
        return t.toString();
      }
    }, new TioTypeReference<String>() {
    });

  }

}
