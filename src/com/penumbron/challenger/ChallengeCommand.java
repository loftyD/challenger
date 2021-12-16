package com.penumbron.challenger;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class ChallengeCommand implements CommandExecutor {
   JavaPlugin plugin;

    public ChallengeCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String cmdName = cmd.getName().toLowerCase();
        
        if (!cmdName.equals("challenge")) {
            return false;
        } else {
        	 if(sender instanceof Player){
        		 Player p = (Player)sender;
        		 Player c = Bukkit.getPlayer(args[0]);
        		 if(!(c instanceof Player)) {
        			sender.sendMessage("The person you wish to challenge is not online.");
        			return false;
        		 }
        		 
        		 if(p == c) {
        			 sender.sendMessage("You can't challenge yourself, stupid.");
        			 return false;
        		 }

        		 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + p.getName() + " pvp");
        		 c.sendMessage(p.getName() +" wants to challenge you to a PvP match. Type /tpaccept to accept.");
        		 Bukkit.dispatchCommand(p, "tpahere " + args[0]);
        		 sender.sendMessage("Sending challenge request to " + args[0]);
        	 }
        }
        return true;
    }
}