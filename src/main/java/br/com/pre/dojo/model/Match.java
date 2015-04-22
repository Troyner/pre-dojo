package br.com.pre.dojo.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável por representar o modelo de um objeto do tipo Match.
 * @author Marcus Vínicius
 * @since 20/04/2015
 */
public class Match {

	private String id;
	private Calendar beginning;
	private Calendar end;
	private Map<String, Player> players;
	private SimpleDateFormat simpleDateFormat;
	
	public Match() {
		players = new HashMap<String, Player>();
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	public Player getPlayer(String name) {
		return players.get(name);
	}
	
	public Player putPlayer(String key, Player player) {
		if ("<WORLD>".equals(key)) {
			return null;
		} else {
			return players.put(key, player);
		}
	}
	
	public Collection<Player> getPlayers() {
		return players.values();
	}
	
	public Collection<Player> getRanking() {
		List<Player> playersList = new ArrayList<Player>();
		playersList.addAll(getPlayers());
		
		Collections.sort(playersList, new Comparator<Player>() {
			@Override
			public int compare(Player player1, Player player2) {
				if (player1.getKills() > player2.getKills()) {
					return -1;
				} else if (player1.getKills() < player2.getKills()) {
					return 1;
				} else {
					if (player1.getDeaths() < player2.getDeaths()) {
						return -1;						
					} else if (player1.getDeaths() > player2.getDeaths()) {
						return 1;
					} else {
						return player1.getName().compareTo(player2.getName());
					}
				}
			}
		});
		
		return playersList;
	}
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getBeginning() {
		return beginning;
	}
	
	public String getFormattedBeginning() {
		return simpleDateFormat.format(beginning.getTime());
	}

	public void setBeginning(Calendar beginning) {
		this.beginning = beginning;
	}

	public Calendar getEnd() {
		return end;
	}

	public String getFormattedEnd() {
		return simpleDateFormat.format(end.getTime());
	}
	
	public void setEnd(Calendar end) {
		this.end = end;
	}
		
}
