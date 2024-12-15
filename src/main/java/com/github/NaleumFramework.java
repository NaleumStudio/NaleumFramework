package com.github;

import com.github.NlFramework.utils.CL;
import org.bukkit.plugin.java.JavaPlugin;

public final class NaleumFramework extends JavaPlugin {
    private static NaleumFramework instance;

    @Override
    public void onEnable() {
        if (instance != null) { return; }
        CL.Send("&9Naleum&bFrameWork &7Enable", this);
        CL.Send("&7Support Discord &8: &9https://discord.gg/XbxTxdf7jh", this);
    }
}
