package org.plugin.cropHarvest;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class CropHarvest extends JavaPlugin {

    public static FileConfiguration config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        config = getConfig();

        getServer().getPluginManager().registerEvents(new EventsInteractSeed(), this);
    }
}
