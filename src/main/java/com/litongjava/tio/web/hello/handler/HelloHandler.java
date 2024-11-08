package com.litongjava.tio.web.hello.handler;

import java.util.HashMap;
import java.util.Map;

import com.litongjava.model.body.RespBodyVo;
import com.litongjava.tio.boot.http.TioRequestContext;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;

public class HelloHandler {
  public HttpResponse ok(HttpRequest request) {
    Map<String, String> data = new HashMap<>();
    RespBodyVo respVo = RespBodyVo.ok(data);
    HttpResponse response = TioRequestContext.getResponse();
    response.setBlockSend(false);
    return response.setJson(respVo);
  }
}
