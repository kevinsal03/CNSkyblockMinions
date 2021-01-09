package me.kevsal.minecraft.skyblockminions.config;

public interface Configuration {

    /**
     * Get the name of this configuration
     * @return the name of the config
     */
    String getConfigPrettyName();

    /**
     * Reload the configuration
     */
    void reloadConfig();

    /**
     * Get the current config version
     * @return int of current config version
     */
    int getConfigVersion();


}
