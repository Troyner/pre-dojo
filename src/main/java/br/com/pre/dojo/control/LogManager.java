package br.com.pre.dojo.control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import br.com.pre.dojo.model.Match;
import br.com.pre.dojo.model.Player;

/**
 * Classe responsável por gerenciar uma o log.
 * @author Marcus Vinícius
 * @since 21/04/2015
 */
public class LogManager {

	private String logPath;
	private BufferedReader bufferedReader;
	
	public LogManager(String logPath) {
		this.logPath = logPath;
	}
	
	public Collection<LogLine> readLine() throws IOException {
		this.bufferedReader = new BufferedReader(new FileReader(logPath));
		
		Collection<LogLine> logLines = new ArrayList<LogLine>();
		
		this.bufferedReader.lines().forEach(line->{
			LogLine logLine = new LogLine(line);
			logLines.add(logLine);
		});

		this.bufferedReader.close();
		
		return logLines;
	}
	
	public Collection<Match> getMatches() throws Exception {
		Player player = null;
		Match match = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar calendar = null;
		Collection<Match> matches = new ArrayList<Match>();
		
		for (LogLine logLine : this.readLine()) {
			
			if (logLine.isMatchStart()) {
				match = new Match();
				match.setId(logLine.getMatchId());
				calendar = Calendar.getInstance();
				calendar.setTime(simpleDateFormat.parse(logLine.getTimestamp()));
				match.setBeginning(calendar);
			} else if (logLine.isMatchEnd()) {
				calendar = Calendar.getInstance();
				calendar.setTime(simpleDateFormat.parse(logLine.getTimestamp()));
				match.setEnd(calendar);
				matches.add(match);
			} else {			
				player = match.getPlayer(logLine.getSubject());
				
				if (player == null) {
					player = new Player();
					player.setName(logLine.getSubject());
					match.putPlayer(logLine.getSubject(), player);
				}
				
				player.addKill();
				
				player = match.getPlayer(logLine.getObject1());
				
				if (player == null) {
					player = new Player();
					player.setName(logLine.getObject1());
					match.putPlayer(logLine.getObject1(), player);
				} 
				
				player.addDeaths();
			}
		}
		
		return matches;
	}

	public String getLogPath() {
		return logPath;
	}

	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}

}
