  package com.litongjava.tio.web.hello.controller;

import com.litongjava.annotation.AController;
import com.litongjava.annotation.RequestPath;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.server.util.Resps;

import lombok.extern.slf4j.Slf4j;
@AController
@RequestPath("/test/json")
@Slf4j
public class TestJsonController {

  @RequestPath(value = "/getBodyString")
  public HttpResponse getBodyString(HttpRequest request) throws Exception {
    String bodyString = request.getBodyString();
    log.info(bodyString);
    HttpResponse ret = Resps.txt(request, bodyString);
    return ret;
  }

}