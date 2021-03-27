package com.zp;

import com.zp.server.HttpServer;

/**
 * @author ZP
 * @date 2020/10/31.
 */
public class HttpServerApplication {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        httpServer.start();
    }
}
