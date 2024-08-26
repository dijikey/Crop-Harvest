package org.plugin.cropHarvest;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventsInteractSeed implements Listener {
    public final List<Material> materials;

    public EventsInteractSeed(List<Material> materials) {
        this.materials = materials;
    }

    @EventHandler
    public void onEnable(PlayerInteractEvent e){
        if (e.getAction().isLeftClick()) return;
        try {
            if (materials.contains(e.getClickedBlock().getType())) {
                Block crop = e.getClickedBlock();
                World world = crop.getWorld();
                Material materialCrop = crop.getType();
                Location location = crop.getLocation();
                switch (materialCrop) {
                    case CARROTS, WHEAT, POTATOES -> takeCrop(crop, location, world, "7");
                    case BEETROOTS -> takeCrop(crop, location, world, "3");
                }
            }
        }catch (NullPointerException err){
            err.getStackTrace();
        }
    }

    public void takeCrop(Block block, Location location, World world, String contains){
        if (block.getBlockData().getAsString().contains(contains)){
            for (ItemStack el : block.getDrops())
            {
                world.dropItemNaturally(location, el);
            }
            world.playSound(location, block.getBlockSoundGroup().getBreakSound(),5, 10);
            world.setType(location, block.getType());
        }
    }
}
