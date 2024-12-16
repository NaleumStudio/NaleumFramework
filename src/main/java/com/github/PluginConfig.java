package com.github;

public class PluginConfig {
    public static boolean enableDB;

    public static void ReloadConfig() {
        NaleumFramework.getInstance().reloadConfig();
        enableDB = NaleumFramework.getInstance().getConfig().getBoolean("database.enabled", true);
    }
}
