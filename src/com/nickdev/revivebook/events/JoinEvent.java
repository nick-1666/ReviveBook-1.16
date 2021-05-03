package com.nickdev.revivebook.events;

import com.nickdev.revivebook.item.ItemManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        //event.getPlayer().setResourcePack("https://github.com/nick-1666/ReviveBook-1.16/blob/txr/ReviveBook.zip?raw=true"); //direct dnload
    }
}
