package me.kevsal.minecraft.skyblockminions.config;

import lombok.Getter;
import me.kevsal.minecraft.skyblockminions.SkyblockMinions;
import org.inventivetalent.pluginannotations.PluginAnnotations;
import org.inventivetalent.pluginannotations.message.MessageBase;
import org.inventivetalent.pluginannotations.message.MessageValue;

/*
* TODO: Make template custom messages.yml lang file
* */

/**
 * Plugin language configuration
 */
@MessageBase(file = "messages.yml")
@SuppressWarnings({"unassigned", "unused"})
public class LangConfiguration implements Configuration {

    @Getter private static Configuration instance;

    public LangConfiguration() {
        instance = this;
        PluginAnnotations.MESSAGE.loadValues(SkyblockMinions.getInstance(), this);
    }

    @Override
    public String getConfigPrettyName() {
        return "Language Configuration";
    }

    @Override
    public void reloadConfig() {
        PluginAnnotations.MESSAGE.loadValues(SkyblockMinions.getInstance(), this);
    }

    @Getter @MessageValue(path = "meta.config-version") private int configVersion;

    /* BEGIN PLUGIN LANGUAGE DEFAULTS */

    /**
     * Access Denied Message
     */
    @Getter @MessageValue(path = "message.no-access", defaultsTo = "&cAccess Denied") private String accessDeniedMessage;

    @Getter @MessageValue(path = "message.close", defaultsTo = "&4&lClose") private String closeMessage;

}
