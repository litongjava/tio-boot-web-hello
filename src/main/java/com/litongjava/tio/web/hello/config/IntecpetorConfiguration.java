 package com.litongjava.tio.web.hello.config;

import com.litongjava.annotation.Initialization;
import com.litongjava.tio.boot.http.interceptor.HttpInteceptorConfigure;
import com.litongjava.tio.boot.http.interceptor.HttpInterceptorModel;
import com.litongjava.tio.boot.server.TioBootServer;
import com.litongjava.tio.web.hello.inteceptor.GlobalInteceptor;
import com.litongjava.tio.web.hello.inteceptor.HelloInteceptor;

//@AConfiguration
public class IntecpetorConfiguration {

  @Initialization
  public void serverInteceptorRoutes() {

    // add global
    HttpInterceptorModel global = new HttpInterceptorModel();
    global.setName("global");
    global.addBlockUrl("/**");
    global.setInterceptor(new GlobalInteceptor());

    HttpInterceptorModel hello = new HttpInterceptorModel();
    hello.setName("hello");
    hello.addBlockUrl("/hello");
    hello.setInterceptor(new HelloInteceptor());

    HttpInteceptorConfigure config = new HttpInteceptorConfigure();
    config.add(global);
    config.add(hello);

    TioBootServer.me().setHttpInteceptorConfigure(config);
  }

}