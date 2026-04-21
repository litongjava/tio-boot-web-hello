package com.litongjava.tio.web.hello.handler;

import java.util.HashMap;
import java.util.Map;

import nexus.io.model.body.RespBodyVo;
import nexus.io.tio.boot.http.TioRequestContext;
import nexus.io.tio.http.common.HttpRequest;
import nexus.io.tio.http.common.HttpResponse;
import nexus.io.tio.http.server.handler.HttpRequestHandler;

public class HelloHandler implements HttpRequestHandler{

  @Override
  public HttpResponse handle(HttpRequest httpRequest) throws Exception {
    Map<String, String> data = new HashMap<>();
    RespBodyVo respVo = RespBodyVo.ok(data);
    HttpResponse response = TioRequestContext.getResponse();
    response.setBlockSend(false);
    return response.setJson(respVo);
  }
}
