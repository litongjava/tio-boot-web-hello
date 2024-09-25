package com.litongjava.tio.web.hello.handler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.litongjava.model.body.RespBodyVo;
import com.litongjava.tio.boot.http.TioRequestContext;
import com.litongjava.tio.core.ChannelContext;
import com.litongjava.tio.core.Tio;
import com.litongjava.tio.http.common.HeaderName;
import com.litongjava.tio.http.common.HeaderValue;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.common.encoder.ChunkEncoder;
import com.litongjava.tio.http.common.sse.ChunkedPacket;
import com.litongjava.tio.http.server.util.SseUtils;
import com.litongjava.tio.utils.http.ContentTypeUtils;
import com.litongjava.tio.utils.hutool.ResourceUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AudioChunkHandler {

  public HttpResponse tts(HttpRequest httpRequest) {
    // 获取channelContext
    ChannelContext channelContext = httpRequest.getChannelContext();
    // 获取response
    HttpResponse response = TioRequestContext.getResponse();

    // 判断文件是否存在
    URL resource = ResourceUtil.getResource("samples/Blowin_in_the_Wind-16k.pcm");
    if (resource == null) {
      response.fail(RespBodyVo.fail("Resource not found"));
      return response;
    }

    // 文件扩展名，根据实际情况设置
    String fileExt = "pcm";
    String contentType = ContentTypeUtils.getContentType(fileExt);

    // 设置为流式输出,这样不会计算content-length,because Content-Length can't be present with
    // Transfer-Encoding
    response.setStream(true);
    // 设置响应头
    response.addHeader(HeaderName.Transfer_Encoding, HeaderValue.from("chunked"));
    response.addHeader(HeaderName.Content_Type, HeaderValue.from(contentType));

    // 发送初始响应头,客户端会自动保持连接
    Tio.send(channelContext, response);

    // 打开文件
    try (InputStream inputStream = resource.openStream()) {
      // 读取文件并响应到客户端
      byte[] buffer = new byte[1024 * 10];
      int bytesRead;
      int i = 0;
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        i++;
        ChunkedPacket ssePacket = new ChunkedPacket(ChunkEncoder.encodeChunk(buffer, bytesRead));
        Tio.send(channelContext, ssePacket);
        log.info("sned:{}:{}", i, bytesRead);
      }

      // 发送结束标志,客户会手动关闭连接
      ChunkedPacket endPacket = new ChunkedPacket(ChunkEncoder.encodeChunk(new byte[0]));
      Tio.send(channelContext, endPacket);

      SseUtils.closeChunkConnection(channelContext);
    } catch (IOException e) {
      response.fail(RespBodyVo.fail("Failed to open resource:" + e.getMessage()));
      return response;
    }

    //发送null
    return null;
  }
}