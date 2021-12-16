package com.penumbron.challenger;

import org.bukkit.plugin.java.JavaPlugin;

public class Challenger extends JavaPlugin {
    // Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	this.getCommand("challenge").setExecutor(new ChallengeCommand(this));
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}
