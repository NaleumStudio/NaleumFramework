package com.github;

import com.github.NlFramework.utils.CL;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import com.github.NlFramework.DB.SQLITE;
import com.github.NlFramework.utils.FILE;

public final class NaleumFramework extends JavaPlugin {
    private static NaleumFramework instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        CL.Send("&9Naleum&bFrameWork &7Enable", this);
        CL.Send("&7Support Discord &8: &9https://discord.gg/XbxTxdf7jh", this);
        FILE.createFolderINE(this.getDataFolder());
        FILE.createFolderINE(new File(this.getDataFolder(), "DB"));
        PluginConfig.ReloadConfig();
    }

    public static NaleumFramework getInstance() {
        return instance;
    }
}
