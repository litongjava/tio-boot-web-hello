package com.litongjava.tio.web.hello.controller;

import com.litongjava.tio.http.server.annotation.RequestPath;
import com.litongjava.tio.utils.resp.RespVo;

@RequestPath
public class OkController {

  @RequestPath("/ok")
  public RespVo ok() {
    return RespVo.ok();
  }
}
