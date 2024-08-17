package com.litongjava.tio.web.hello.handler;

import java.util.HashMap;
import java.util.Map;

import com.litongjava.tio.boot.http.TioRequestContext;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.utils.resp.RespVo;

public class HelloHandler {
  public HttpResponse hello(HttpRequest request) {
    Map<String, String> data = new HashMap<>();
    RespVo respVo = RespVo.ok(data);
    return TioRequestContext.getResponse().setJson(respVo);

  }
}
