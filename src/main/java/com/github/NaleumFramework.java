package com.github;

import com.github.NlFramework.Commands;
import com.github.NlFramework.DB.SQLITE;
import com.github.NlFramework.utils.CL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.NlFramework.utils.FILE;
import com.github.NlFramework.utils.HttpServerHost;

import java.io.IOException;

public final class NaleumFramework extends JavaPlugin {
    private static NaleumFramework instance;

    public static void pluginLoad() {
        PluginConfig.ReloadConfig();
        //placeholderapi
        if (PluginConfig.enablePlaceHolderAPI) {
            if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                new PlaceHolderAPI().register();
                CL.Send("&c[PAPI] &7Successfully registered API", instance);
            } else {
                CL.Send("&c[PAPI] &7PlaceHolderAPI not found", instance);
            }
        }
        //file
        FILE.createFolder(NaleumFramework.getInstance().getDataFolder());
        instance.saveResource("HttpServer/index.html", false);
        instance.saveResource("HttpServer/script.js", false);
        instance.saveResource("HttpServer/style.css", false);
        instance.saveResource("HttpServer/assets/logo.png", false);
        //HttpServer
        if (PluginConfig.enableHttpServer) {
            try {
                HttpServerHost.startServer(instance, PluginConfig.httpIp,PluginConfig.httpPort);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        SQLITE.InitDatabase(instance);
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
