package com.litongjava.tio.web.hello.controller;

import com.jfinal.kit.Kv;
import com.litongjava.tio.http.server.annotation.RequestPath;
import com.litongjava.tio.utils.resp.RespVo;

@RequestPath("/base")
public class BaseController {

  public RespVo date(java.util.Date date) {
    Kv kv = Kv.create();
    kv.set("date", date);
    return RespVo.ok(kv);
  }

  public RespVo string(String name, Integer age) {
    Kv kv = Kv.create();
    kv.set("name", name);
    kv.set("age", age);
    return RespVo.ok(kv);
  }

}
