package br.com.pre.dojo.model;

/**
 * Classe responsável por representar o modelo de um objeto do tipo Player.
 * @author Marcus Vínicius
 * @since 20/04/2015
 */
public class Player {

	private String name;
	private int kills;
	private int deaths;
	
	public void addKill() {
		if (!"<WORLD>".equals(name)) {
			kills++;
		}
	}
	
	public void addDeaths() {
		deaths++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public Integer getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
		
}
