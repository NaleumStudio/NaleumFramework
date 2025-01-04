package com.github;

public class PluginConfig {
    public static boolean enableDB;
    public static boolean enablePlaceHolderAPI;
    public static boolean enableHttpServer;
    public static int httpPort;
    public static String httpIp;

    public static void ReloadConfig() {
        NaleumFramework.getInstance().reloadConfig();
        enableDB = NaleumFramework.getInstance().getConfig().getBoolean("database.enabled", true);
        enablePlaceHolderAPI = NaleumFramework.getInstance().getConfig().getBoolean("PlaceHolderAPI", true);
        enableHttpServer = NaleumFramework.getInstance().getConfig().getBoolean("HttpServer.enabled", false);
        httpPort = NaleumFramework.getInstance().getConfig().getInt("HttpServer.port", 8080);
        httpIp = NaleumFramework.getInstance().getConfig().getString("HttpServer.server-ip", "localhost");
    }
}
