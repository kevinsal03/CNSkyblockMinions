package me.kevsal.minecraft.skyblockminions.config;

import me.kevsal.minecraft.skyblockminions.SkyblockMinions;

public class ConfigManager {

    /**
     * An unnecessary abstraction to clean up the Main plugin class
     * Loads plugin configs on plugin startup
     */
    public static void loadConfigs() {
        SkyblockMinions plugin = SkyblockMinions.getInstance();

        plugin.saveDefaultConfig(); // Save the default Main config.yml

        // Set the main configuration
        plugin.setMainConfiguration(new MainConfiguration());
        // Set the optional Lang configuration
        plugin.setLangConfiguration(new LangConfiguration());
    }


}
