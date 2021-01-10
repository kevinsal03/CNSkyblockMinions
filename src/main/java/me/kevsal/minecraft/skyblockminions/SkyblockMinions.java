package me.kevsal.minecraft.skyblockminions;

import lombok.Getter;
import lombok.Setter;
import me.kevsal.minecraft.skyblockminions.config.ConfigManager;
import me.kevsal.minecraft.skyblockminions.config.LangConfiguration;
import me.kevsal.minecraft.skyblockminions.config.MainConfiguration;
import me.kevsal.minecraft.skyblockminions.listeners.ChunkEvents;
import me.kevsal.minecraft.skyblockminions.listeners.InventoryEvents;
import me.kevsal.minecraft.skyblockminions.listeners.TestingListeners;
import me.kevsal.minecraft.skyblockminions.minions.virtual.VirtualMinionManager;
import me.kevsal.minecraft.skyblockminions.storage.DatabaseManager;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class SkyblockMinions extends JavaPlugin {

    @Getter private static SkyblockMinions instance;

    // Metrics plugin ID
    private static final int BSTATS_METRICS_PLUGIN_ID = 9939;

    @Override
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
            return;
        }

        // Build the Virtual from DB. TODO: Make this a Bukkit Runnable and move to happen on startup and then repeat ~30s
        VirtualMinionManager.buildVirtualMinionsFromDB();

        // Register events
        // getServer().getPluginManager().registerEvents(new ChunkEvents(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);

        /* For testing only */
        getServer().getPluginManager().registerEvents(new TestingListeners(), this);

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
