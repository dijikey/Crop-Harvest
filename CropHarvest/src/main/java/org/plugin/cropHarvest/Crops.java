package org.plugin.cropHarvest;

import org.bukkit.Material;

import static org.plugin.cropHarvest.CropHarvest.config;

public enum Crops {
    WHEAT(Material.WHEAT, config.getBoolean("WHEAT.isEnable"), config.getInt("WHEAT.multiplier"), "7") ,
    POTATOES(Material.POTATOES, config.getBoolean("POTATOES.isEnable"), config.getInt("POTATOES.multiplier"), "7") ,
    CARROTS(Material.CARROTS, config.getBoolean("CARROTS.isEnable"), config.getInt("CARROTS.multiplier"), "7") ,
    BEETROOTS(Material.BEETROOTS, config.getBoolean("BEETROOTS.isEnable"), config.getInt("BEETROOTS.multiplier"), "3"),
    COCOA(Material.COCOA, config.getBoolean("COCOA.isEnable"), config.getInt("COCOA.multiplier"), "2"),
    NETHER_WART(Material.NETHER_WART, config.getBoolean("NETHER_WART.isEnable"), config.getInt("NETHER_WART.multiplier"), "3");

    public final Material material;
    public final boolean isEnable;
    public final int multiplier;
    public final String maxAge;

    Crops(Material material, boolean isEnable, int multiplier, String maxAge) {
        this.material = material;
        this.isEnable = isEnable;
        this.multiplier = multiplier;
        this.maxAge = maxAge;
    }
}
