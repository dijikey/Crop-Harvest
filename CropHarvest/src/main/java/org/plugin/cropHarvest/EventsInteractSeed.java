package org.plugin.cropHarvest;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventsInteractSeed implements Listener {

    @EventHandler
    public void onEnable(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = e.getClickedBlock();
            try {
                for (Crops crop : Crops.values()) {
                    if (crop.material == block.getType() && crop.isEnable && block.getBlockData().getAsString().contains(crop.maxAge)) {
                        takeCrop(block, block.getLocation(), block.getWorld(), crop.multiplier);
                    }
                }
            } catch (NullPointerException err) {
                err.getStackTrace();
            }
        }
    }

    private void takeCrop(Block block, Location location, World world, int multiplier){
        for (ItemStack el : block.getDrops())
        {
            world.dropItemNaturally(location, el);

            for (int i = 1; i < multiplier; i++){
                world.dropItemNaturally(location, el);
            }
        }
        world.playSound(location, block.getBlockSoundGroup().getBreakSound(),5, 10);
        world.setType(location, block.getType());
    }
}
