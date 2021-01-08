package me.kevsal.minecraft.skyblockminions;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyblockMinions extends JavaPlugin {

    private static SkyblockMinions instance;

    // Metrics plugin ID
    private static final int BSTATS_METRICS_PLUGIN_ID = 9939;

    @Override
    public void onEnable() {
        // Set instance of plugin when loaded by server
        instance = this;

        // Enable metrics
        Metrics metrics = new Metrics(this, BSTATS_METRICS_PLUGIN_ID);
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
