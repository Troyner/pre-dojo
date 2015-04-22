package br.com.pre.dojo.control;

import java.net.URL;
import java.util.Collection;

import br.com.pre.dojo.model.Match;
import br.com.pre.dojo.model.Player;

/**
 * Classe responsável por imprimir os rankings encontrados em uma partida.
 * @author Marcus Vinícius
 * @since 21/04/2015
 */
public class Printter {

	public void printHeader(String matchId) {
		System.out.println("*******************************************************");
		System.out.printf("* Match: %-20s                         *\n", matchId);
		System.out.println("*******************************************************");
	}

	public void printBody(Collection<Player> players) {
		for (Player player : players) {
			System.out.printf("* Name: %-19s", player.getName());
			System.out.printf("   Kills: %-3d", player.getKills());
			System.out.printf("   Deaths: %-3d*\n", player.getDeaths());
		}
		
		System.out.println("*******************************************************\n");
	}
	
	public void generateRanking() throws Exception {
		URL url = getClass().getResource("/log3.txt");
		String caminho = url.getPath();
		LogManager logManager = new LogManager(caminho);
		
		for (Match match : logManager.getMatches()) {
			this.printHeader(match.getId());
			this.printBody(match.getRanking());
		}
	}

}
