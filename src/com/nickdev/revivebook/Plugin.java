package com.nickdev.revivebook;

import com.nickdev.revivebook.commands.GiveReviveBook;
import com.nickdev.revivebook.events.OffHandPrevention;
import com.nickdev.revivebook.events.ReviveEvent;
import com.nickdev.revivebook.item.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemManager.init();
        getServer().getPluginManager().registerEvents(new OffHandPrevention(), this);
        getServer().getPluginManager().registerEvents(new ReviveEvent(), this);
        getCommand("givebook").setExecutor(new GiveReviveBook());
    }

    @Override
    public void onDisable() { }

}