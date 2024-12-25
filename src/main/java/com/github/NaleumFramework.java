package com.github;

import com.github.NlFramework.Commands;
import com.github.NlFramework.utils.CL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.NlFramework.utils.FILE;

public final class NaleumFramework extends JavaPlugin {
    private static NaleumFramework instance;

    public static void pluginLoad() {
        PluginConfig.ReloadConfig();
        //placeholderapi
        if (PluginConfig.enablePlaceHolderAPI) {
            if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                new PlaceHolderAPI().register();
                CL.Send("&c[PAPI] &7Successfully registered API", NaleumFramework.getInstance());
            } else {
                CL.Send("&c[PAPI] &7PlaceHolderAPI not found", NaleumFramework.getInstance());
            }
        }
        //file
        FILE.createFolderINE(NaleumFramework.getInstance().getDataFolder());
    }

    @Override
    public void onEnable() {
        instance = this;
        getCommand("nlreload").setExecutor(new Commands());
        saveDefaultConfig();
        pluginLoad();
        //message
        CL.Send("&bNaleumFrameWork &7Enabled", NaleumFramework.getInstance());
        CL.Send("&7Support Discord &8: &9https://discord.gg/XbxTxdf7jh", NaleumFramework.getInstance());
    }

    public static NaleumFramework getInstance() {
        return instance;
    }
}
