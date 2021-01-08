package me.kevsal.minecraft.skyblockminions;

import org.bukkit.plugin.java.JavaPlugin;

public class SkyblockMinions extends JavaPlugin {

    private static SkyblockMinions instance;

    @Override
    public void onEnable() {
        // Set instance of plugin when loaded by server
        instance = this;
    }

    @Override
    public void onDisable() {
        // If plugin unloaded, clear the instance
        instance = null;
    }


    // Get instance of this plugin
    public static SkyblockMinions getInstance() {
        return instance;
    }

}
