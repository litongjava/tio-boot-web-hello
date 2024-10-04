package com.litongjava.tio.web.hello.controller;
import com.litongjava.annotation.EnableCORS;
import com.litongjava.annotation.RequestPath;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.server.util.Resps;
@RequestPath("/admin-api/system/captcha")
@EnableCORS
public class CaptchaController {

  @RequestPath("/check")
  public HttpResponse check(HttpRequest request) {
    HttpResponse response = Resps.json(request, "OK");
    return response;
  }
}