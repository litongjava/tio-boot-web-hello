package com.litongjava.tio.web.hello.inteceptor;

import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.common.RequestLine;
import com.litongjava.tio.http.server.intf.HttpRequestInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloInteceptor implements HttpRequestInterceptor {

  public HttpResponse doBeforeHandler(HttpRequest request, RequestLine requestLine, HttpResponse responseFromCache) throws Exception {
    log.info("request", request);
    return null;
  }

  public void doAfterHandler(HttpRequest request, RequestLine requestLine, HttpResponse response, long cost) throws Exception {
    log.info("request", request);

  }

}