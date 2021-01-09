package me.kevsal.minecraft.skyblockminions;

import lombok.Getter;
import lombok.Setter;
import me.kevsal.minecraft.skyblockminions.config.ConfigManager;
import me.kevsal.minecraft.skyblockminions.config.LangConfiguration;
import me.kevsal.minecraft.skyblockminions.config.MainConfiguration;
import me.kevsal.minecraft.skyblockminions.storage.DatabaseManager;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyblockMinions extends JavaPlugin {

    @Getter private static SkyblockMinions instance;

    // Metrics plugin ID
    private static final int BSTATS_METRICS_PLUGIN_ID = 9939;

    @Override
    @SuppressWarnings("unused")
    public void onEnable() {
        // Set instance of plugin when loaded by server
        instance = this;

        // Load Configurations
        ConfigManager.loadConfigs();

        // Enable metrics
        Metrics metrics = new Metrics(this, BSTATS_METRICS_PLUGIN_ID);

        // Init the database, disable plugin if failed.
        if (!DatabaseManager.initDatabase()) {
            getSLF4JLogger().error("Plugin disabled due to database initialization error!");
            this.setEnabled(false);
        }

        getSLF4JLogger().info("Plugin enabled.");
    }

    @Override
    public void onDisable() {
        // Close the database
        DatabaseManager.closeDatabase();
        // If plugin unloaded, clear the instance
        instance = null;

        getSLF4JLogger().info("Plugin disabled.");
    }

    /**
     * Plugin's main config
     */
    @Getter @Setter private MainConfiguration mainConfiguration;

    /**
     * Plugin's language config
     */
    @Getter @Setter private LangConfiguration langConfiguration;
}
