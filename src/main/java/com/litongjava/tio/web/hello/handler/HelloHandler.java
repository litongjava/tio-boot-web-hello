package com.litongjava.tio.web.hello.handler;

import java.util.HashMap;
import java.util.Map;

import com.litongjava.model.body.RespBodyVo;
import com.litongjava.tio.boot.http.TioRequestContext;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloHandler {
  public HttpResponse ok(HttpRequest request) {
    log.info(request.getRequestLine().toString());
    Map<String, String> data = new HashMap<>();
    RespBodyVo respVo = RespBodyVo.ok(data);
    return TioRequestContext.getResponse().setJson(respVo);
  }
}
