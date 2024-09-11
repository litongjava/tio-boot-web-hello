package com.litongjava.tio.web.hello.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.kit.Kv;
import com.litongjava.tio.boot.server.TioBootServer;
import com.litongjava.tio.http.server.annotation.RequestPath;
import com.litongjava.tio.utils.cache.AbsCache;
import com.litongjava.tio.utils.cache.CacheFactory;
import com.litongjava.tio.utils.resp.RespVo;

@RequestPath("/")
public class IndexController {
  @RequestPath()
  public RespVo index() {
    return RespVo.ok();
  }

  public RespVo cache() {
    CacheFactory cacheFactory = TioBootServer.me().getServerTioConfig().getCacheFactory();
    AbsCache absCache = cacheFactory.register("test001", 300L, 3000L);
    absCache.put("key", "value");
    Map<String, ? extends AbsCache> map = cacheFactory.getMap();

    Kv kv = Kv.by("cacheFactory", cacheFactory);
    kv.set("map", map);

    for (Map.Entry<String, ? extends AbsCache> entry : map.entrySet()) {
      String cacheName = entry.getKey();
      AbsCache cache = entry.getValue();
      Collection<String> keysCollection = cache.keysCollection();
      Map<String, Object> cacheMap = new HashMap<>();
      for (String key : keysCollection) {
        cacheMap.put(key, cache.get(key));
      }
      kv.set("cache_" + cacheName, cacheMap);
    }

    return RespVo.ok(kv);
  }
}
