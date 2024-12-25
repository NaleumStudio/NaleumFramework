package com.github.NlFramework;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import com.github.PluginConfig;
import com.github.NaleumFramework;
import com.github.NlFramework.utils.CL;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equalsIgnoreCase("nlreload")) {
            long startTime = System.currentTimeMillis();
            PluginConfig.ReloadConfig();
            NaleumFramework.pluginLoad();
            long endTime = System.currentTimeMillis();
            sender.sendMessage(CL.G + "Successfully reloaded Plugin");
            sender.sendMessage(CL.GR + "- Time taken: " + CL.W + (endTime - startTime) + "ms");
            return true;
        }
        return false;
    }
}
