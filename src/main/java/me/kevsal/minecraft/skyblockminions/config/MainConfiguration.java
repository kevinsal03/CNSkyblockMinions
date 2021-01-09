package me.kevsal.minecraft.skyblockminions.config;

import lombok.Getter;
import me.kevsal.minecraft.skyblockminions.SkyblockMinions;
import org.inventivetalent.pluginannotations.PluginAnnotations;
import org.inventivetalent.pluginannotations.config.ConfigValue;

import java.util.ArrayList;

@SuppressWarnings({"unassigned", "unused"})
public class MainConfiguration implements Configuration{

    @Getter private static Configuration instance;

    @Getter @ConfigValue(path = "meta.config-version") private int configVersion;

    public MainConfiguration() {
        instance = this;
        PluginAnnotations.CONFIG.loadValues(SkyblockMinions.getInstance(), this);
    }

    @Override
    public String getConfigPrettyName() {
        return "Main Plugin Configuration";
    }

    @Override
    public void reloadConfig() {
        PluginAnnotations.CONFIG.loadValues(SkyblockMinions.getInstance(), this);
    }

    /* PLUGIN CONFIG GETTERS */

    /**
     * Worlds the plugin is allowed to operate in
     */
    @Getter @ConfigValue(path = "allowed-worlds") ArrayList<String> allowedWorlds;

}
