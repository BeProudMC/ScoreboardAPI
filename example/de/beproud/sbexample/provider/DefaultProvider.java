package de.beproud.sbexample.provider;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

import de.beproud.sbexample.provider.type.ExampleProvider;
import de.beproud.scoreboard.ScoreboardProvider;
import de.beproud.scoreboard.ScoreboardText;

public class DefaultProvider extends ScoreboardProvider {
	
	private HashMap<ProviderType, ScoreboardProvider> defaultProvider;
	
	public DefaultProvider() {
		this.defaultProvider = new HashMap<>();
		
		this.defaultProvider.put(ProviderType.EXAMPLE, new ExampleProvider());
	}
	
	@Override
	public String getTitle(Player p) {
		return this.defaultProvider.get(ProviderType.EXAMPLE).getTitle(p);
	}
	
	@Override
	public List<ScoreboardText> getLines(Player p) {
		return this.defaultProvider.get(ProviderType.EXAMPLE).getLines(p);
	}
	
	public enum ProviderType {
		EXAMPLE;
	}
	
}