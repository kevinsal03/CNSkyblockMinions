package me.kevsal.minecraft.skyblockminions.listeners;

import me.kevsal.minecraft.skyblockminions.minions.virtual.VirtualMinionManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TestingListeners implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().sendMessage("Opening inv for minion 1");
        e.getPlayer().openInventory(VirtualMinionManager.getVirtualMinions().get(1).getInventory());
    }

}
