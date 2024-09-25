package com.litongjava.tio.web.hello.controller;

import com.litongjava.annotation.RequestPath;
import com.litongjava.model.body.RespBodyVo;

@RequestPath
public class OkController {

  @RequestPath("/ok")
  public RespBodyVo ok() {
    return RespBodyVo.ok();
  }
}
