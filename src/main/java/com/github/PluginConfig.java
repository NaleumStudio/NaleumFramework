package com.github;

public class PluginConfig {
    public static boolean enableDB;
    public static boolean enablePlaceHolderAPI;

    public static void ReloadConfig() {
        NaleumFramework.getInstance().reloadConfig();
        enableDB = NaleumFramework.getInstance().getConfig().getBoolean("database.enabled", true);
        enablePlaceHolderAPI = NaleumFramework.getInstance().getConfig().getBoolean("PlaceHolderAPI", true);
    }
}
