package me.naphy;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class NebulaKBCancel extends JavaPlugin {
    public static NebulaKBCancel plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[" + this.getName() + "] Plugin is now enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[" + this.getName() + "] Plugin is now disabled!");
    }
}
