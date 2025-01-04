package com.github.NlFramework.utils;

import com.github.NaleumFramework;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.*;
import java.nio.file.Files;
import com.github.NlFramework.utils.CL;

public class HttpServerHost {
    private static HttpServer server;
    public static void startServer(JavaPlugin plugin, String host, int port) throws IOException {
        if (server != null) {
            server.stop(0);
        }

        File dataFolder = plugin.getDataFolder();
        File httpServerFolder = new File(dataFolder, "HttpServer");

        server = HttpServer.create(new InetSocketAddress(host, port), 0);

        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String path = exchange.getRequestURI().getPath();

                if (path.equals("/")) {
                    path = "/index.html";
                }

                File file = new File(httpServerFolder, path);

                if (file.exists() && !file.isDirectory()) {
                    exchange.sendResponseHeaders(200, file.length());
                    Files.copy(file.toPath(), exchange.getResponseBody());
                } else {
                    String response = "404 Not Found";
                    exchange.sendResponseHeaders(404, response.getBytes().length);
                    exchange.getResponseBody().write(response.getBytes());
                }
                exchange.getResponseBody().close();
            }
        });

        server.start();
        CL.Send("&6[HttpServer] &7Successfully host HttpServer", NaleumFramework.getInstance());
    }
}
