package com.github;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.bukkit.Bukkit;

public class PlaceHolderAPI extends PlaceholderExpansion {

    @Override
    @NotNull
    public String getAuthor() {
        return "DevNyanHa";
    }

    @Override
    @NotNull
    public String getIdentifier() {
        return "nl";
    }

    @Override
    @NotNull
    public String getVersion() {
        return NaleumFramework.getInstance().getDescription().getVersion();
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        if (params.equalsIgnoreCase("player")) {
            return player.getName();
        }
        if (params.equalsIgnoreCase("version")) {
            return NaleumFramework.getInstance().getDescription().getVersion();
        }
        return null;
    }
}
