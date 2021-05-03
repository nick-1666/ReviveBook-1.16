package com.nickdev.revivebook.item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public  static ItemStack reviveBook;

    public static void init() {
        createReviveBook();
    }

    public static void createReviveBook() {
        ItemStack item = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(6942069); //for you texturepack nerds
        meta.setDisplayName("§a§lRevive Book");

        List<String> lore = new ArrayList<>();
        lore.add("§7Write the name of the soul,");
        lore.add("§7and they will revive as a whole.");

        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);

        meta.setLore(lore);
        item.setItemMeta(meta);
        reviveBook = item;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("revive_book"), item);
        recipe.shape("TGT",
                "BNB",
                "TGT");
        recipe.setIngredient('T', Material.TOTEM_OF_UNDYING);
        recipe.setIngredient('G', Material.GOLD_BLOCK);
        recipe.setIngredient('B', Material.PAPER);
        recipe.setIngredient('N', Material.NETHER_STAR);

        Bukkit.getServer().addRecipe(recipe);

    }

}