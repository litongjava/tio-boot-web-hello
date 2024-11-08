package com.litongjava.tio.web.hello.config;

import com.litongjava.annotation.Initialization;
import com.litongjava.tio.boot.server.TioBootServer;
import com.litongjava.tio.server.ServerTioConfig;

// @AConfiguration
public class TioBootServerConfig {

  @Initialization
  public void config() {
    TioBootServer server = TioBootServer.me();
    ServerTioConfig serverTioConfig = server.getServerTioConfig();
    serverTioConfig.debug = true;

    // 设置ip监控
    // serverTioConfig.setIpStatListener(MyIpStatListener.me);
    // 设置ip统计时间段
    // serverTioConfig.ipStats.addDurations(IpStatDuration.IPSTAT_DURATIONS);
  }
}
