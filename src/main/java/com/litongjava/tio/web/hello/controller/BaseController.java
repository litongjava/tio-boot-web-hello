package com.litongjava.tio.web.hello.controller;

import com.jfinal.kit.Kv;
import com.litongjava.annotation.RequestPath;
import com.litongjava.model.body.RespBodyVo;

@RequestPath("/base")
public class BaseController {

  public RespBodyVo date(java.util.Date date) {
    Kv kv = Kv.create();
    kv.set("date", date);
    return RespBodyVo.ok(kv);
  }

  public RespBodyVo string(String name, Integer age) {
    Kv kv = Kv.create();
    kv.set("name", name);
    kv.set("age", age);
    return RespBodyVo.ok(kv);
  }

}
