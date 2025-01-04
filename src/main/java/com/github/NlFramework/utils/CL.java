package com.github.NlFramework.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class CL extends JavaPlugin {

    public static ChatColor R = ChatColor.RED;
    public static ChatColor G = ChatColor.GREEN;
    public static ChatColor B = ChatColor.BLUE;
    public static ChatColor Y = ChatColor.YELLOW;
    public static ChatColor A = ChatColor.AQUA;
    public static ChatColor LP = ChatColor.LIGHT_PURPLE;
    public static ChatColor DP = ChatColor.DARK_PURPLE;
    public static ChatColor DGR = ChatColor.DARK_GRAY;
    public static ChatColor DG = ChatColor.DARK_GREEN;
    public static ChatColor DB = ChatColor.DARK_BLUE;
    public static ChatColor W = ChatColor.WHITE;
    public static ChatColor BL = ChatColor.BLACK;
    public static ChatColor M = ChatColor.MAGIC;
    public static ChatColor GR = ChatColor.GRAY;
    public static ChatColor I = ChatColor.ITALIC;
    public static ChatColor U = ChatColor.UNDERLINE;
    public static ChatColor S = ChatColor.STRIKETHROUGH;

    public static void Send(String text) {
        text = ChatColor.translateAlternateColorCodes('&', text);
        Bukkit.getConsoleSender().sendMessage(text);
    }
    public static void Send(String text, JavaPlugin plugin) {
        text = ChatColor.translateAlternateColorCodes('&', "&7[" + plugin.getName() + "] " + text);
        Bukkit.getConsoleSender().sendMessage(text);
    }
}
