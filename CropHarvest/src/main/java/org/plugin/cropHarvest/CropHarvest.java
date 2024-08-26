package org.plugin.cropHarvest;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class CropHarvest extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        List<Material> materials = new ArrayList<>();

        for (String el : config.getStringList("")){
            materials.add(Material.getMaterial(el));
        }


        getServer().getPluginManager().registerEvents(new EventsInteractSeed(materials), this);
    }
}
