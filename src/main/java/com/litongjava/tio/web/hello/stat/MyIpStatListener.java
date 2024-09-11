package com.litongjava.tio.web.hello.stat;

import com.litongjava.tio.core.ChannelContext;
import com.litongjava.tio.core.Node;
import com.litongjava.tio.core.TioConfig;
import com.litongjava.tio.core.intf.Packet;
import com.litongjava.tio.core.stat.IpStat;
import com.litongjava.tio.core.stat.IpStatListener;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.utils.HttpIpUtils;
import com.litongjava.tio.utils.json.JsonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyIpStatListener implements IpStatListener {
  public static final MyIpStatListener me = new MyIpStatListener();

  private MyIpStatListener() {
  }

  @Override
  public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect, IpStat ipStat) throws Exception {
    if (log.isInfoEnabled()) {
      log.info("连接成功：{}", JsonUtils.toJson(ipStat));
    }
  }

  @Override
  public void onAfterReceivedBytes(ChannelContext channelContext, int receivedBytes, IpStat ipStat) throws Exception {
    if (log.isInfoEnabled()) {
      log.info("接收字节数：{}", JsonUtils.toJson(ipStat));
    }
  }

  @Override
  public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize, IpStat ipStat) throws Exception {
    if (log.isInfoEnabled()) {
      if (packet instanceof HttpRequest) {
        // 获取真实IP
        String realIp = HttpIpUtils.getRealIp((HttpRequest) packet);
        // 设置真实IP
        ipStat.setIp(realIp);
        int port = channelContext.getClientNode().getPort();
        channelContext.setProxyClientNode(new Node(realIp, port));
        TioConfig tioConfig = channelContext.getTioConfig();
        // 将真实IP添加到内置监控
        for (Long v : tioConfig.ipStats.durationList) {
          tioConfig.ipStats.get(v, channelContext);
        }
      }
      log.info("消息解码完成：{} {}", packet.logstr(), JsonUtils.toJson(ipStat));
    }
  }

  @Override
  public void onDecodeError(ChannelContext channelContext, IpStat ipStat) {
    if (log.isInfoEnabled()) {
      log.info("解码错误：{}", JsonUtils.toJson(ipStat));
    }
  }

  @Override
  public void onAfterHandled(ChannelContext channelContext, Packet packet, IpStat ipStat, long cost) throws Exception {
    if (log.isInfoEnabled()) {
      log.info("消息处理完成：{} {}", packet.logstr(), JsonUtils.toJson(ipStat));
    }
  }

  @Override
  public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess, IpStat ipStat) throws Exception {
    if (log.isInfoEnabled()) {
      log.info("消息发送完成：{} {}", packet.logstr(), JsonUtils.toJson(ipStat));
    }
  }

  @Override
  public void onExpired(TioConfig tioConfig, IpStat ipStat) {
    // 当统计数据过期时，可以将数据入库或记录日志
    if (log.isInfoEnabled()) {
      log.info("统计数据过期，数据如下：{}", JsonUtils.toJson(ipStat));
    }
  }
}