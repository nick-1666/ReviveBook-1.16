package com.nickdev.revivebook.events;

import com.nickdev.revivebook.item.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BookMeta;

public class ReviveEvent implements Listener {

    @EventHandler
    public void onEvent(PlayerEditBookEvent event) throws InterruptedException {
        BookMeta meta = event.getNewBookMeta();

        String RevPlayer;
        RevPlayer = meta.getPage(1);
        Player player = Bukkit.getServer().getPlayer(RevPlayer);

        if(player == null) {
            event.getPlayer().sendMessage("§7The book demands a username.");
            return;
        } else {
            if (!(event.isSigning())) {
                event.getPlayer().sendMessage("§7The book wants to know your decission is final. Sign it.");
                return;
            }

            if(event.getPlayer().getInventory().getItemInMainHand().getEnchantments().equals(ItemManager.reviveBook.getEnchantments())) {
                event.getPlayer().getInventory().getItemInMainHand().setAmount(0);
            } else {
                event.getPlayer().getInventory().getItemInOffHand().setAmount(0);
            }

            event.getPlayer().sendMessage("§a§lAsk and you shall recieve...");
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_TOTEM_USE, 3.0f, 1f);
            player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 3.0f, 1f);
            player.sendMessage("§a§lRevived!");
            player.setGameMode(GameMode.SURVIVAL);
            player.setNoDamageTicks(20);
        }

    }
}
