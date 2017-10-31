package de.beproud.sbexample;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ScoreboardExample extends JavaPlugin implements Listener {
		
	private static ScoreboardManager scoreboardManager;
	
	@Override
	public void onEnable() {
		scoreboardManager = new ScoreboardManager();
		
		this.startUpdateTask();
		
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	private void startUpdateTask() {
		Bukkit.getScheduler().runTaskTimer(this, () -> {
			scoreboardManager.getPlayerScoreboards().values().forEach((scoreboard) -> scoreboard.update());
		}, 0L, 1L); // Very fast, every tick.
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		scoreboardManager.addToPlayerCache(p);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		scoreboardManager.removeFromPlayerCache(p);
	}
	
}