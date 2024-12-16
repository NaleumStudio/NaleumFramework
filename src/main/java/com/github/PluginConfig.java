package com.github;

import java.util.HashMap;

public class PluginConfig {
    public static boolean enableDB;

    public void ReloadConfig() {
        NaleumFramework.getInstance().reloadConfig();
        enableDB = NaleumFramework.getInstance().getConfig().getBoolean("database.enabled", true);
    }
}
