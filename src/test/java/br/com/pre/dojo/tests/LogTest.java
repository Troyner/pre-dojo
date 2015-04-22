package br.com.pre.dojo.tests;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.pre.dojo.control.LogManager;
import br.com.pre.dojo.model.Match;
import br.com.pre.dojo.model.Player;

/**
 * Classe responsável por ter os testes da aplicação.
 * @author Marcus Vinícius
 * @since 20/04/2015
 */
public class LogTest {

	@Test
	public void readEmptyFile() throws Exception {
		URL url = getClass().getResource("/log1.txt");
		String caminho = url.getPath();
		LogManager logManager = new LogManager(caminho);
		
		Assert.assertTrue(logManager.getMatches().isEmpty());
	}
		
	@Test
	public void getMatchData() throws IOException, Exception {
		URL url = getClass().getResource("/log2.txt");
		String caminho = url.getPath();
		LogManager logManager = new LogManager(caminho);
				
		for (Match match : logManager.getMatches()) {
			Assert.assertEquals("23/04/2013 15:34:22", match.getFormattedBeginning());
			Assert.assertEquals("23/04/2013 15:39:22", match.getFormattedEnd());
		}
	}
	
		
	@Test
	public void generateRankingByOneMatch() throws Exception {
		URL url = getClass().getResource("/log2.txt");
		String caminho = url.getPath();
		LogManager logManager = new LogManager(caminho);
		
		int matchCount = 0;
		String matchId = null;
		List<String> names = new ArrayList<String>();
		
		for (Match match : logManager.getMatches()) {
			matchId = match.getId();
			for (Player player : match.getRanking()) {
				names.add(player.getName());
			}
			matchCount++;
		}
		
		Assert.assertEquals(1, matchCount);
		Assert.assertEquals("Roman", names.get(0));
		Assert.assertEquals("Nick", names.get(1));
		Assert.assertEquals("11348965", matchId);
	}
	
	@Test
	public void consistRankingData() throws Exception {
		URL url = getClass().getResource("/log2.txt");
		String caminho = url.getPath();
		LogManager logManager = new LogManager(caminho);
		
		int romanKills = 0;
		int romanDeaths = 0;
		int nickKills = 0;
		int nickDeaths = 0;
		
		for (Match match : logManager.getMatches()) {
			for (Player player : match.getRanking()) {
				if ("Roman".equals(player.getName())) {
					romanKills = player.getKills();
					romanDeaths = player.getDeaths();
				}
				
				if ("Nick".equals(player.getName())) {
					nickKills = player.getKills();
					nickDeaths = player.getDeaths();
				}
			}
		}
		
		Assert.assertEquals(1, romanKills);
		Assert.assertEquals(0, romanDeaths);
		Assert.assertEquals(0, nickKills);
		Assert.assertEquals(2, nickDeaths);
	}
	
	@Test
	public void generateRankingByManyMatches() throws Exception {
		URL url = getClass().getResource("/log3.txt");
		String caminho = url.getPath();
		LogManager logManager = new LogManager(caminho);
		
		for (Match match : logManager.getMatches()) {
			System.out.println("Match ID: " + match.getId());
			for (Player player : match.getRanking()) {
				System.out.println("Player: " + player.getName() + " - Kills: " + player.getKills() + " Deaths: " + player.getDeaths());
			}
		}
	}
		
}
