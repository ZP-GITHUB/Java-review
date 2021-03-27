package com.zp.handle;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author ZP
 * @date 2020/10/31.
 * 这里有 POST 请求和 GET 请求。因此我们需要首先定义一个处理 HTTP Request 的接口。
 */
public interface RequestHandler {
    Object handle(FullHttpRequest fullHttpRequest);
}
