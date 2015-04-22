package br.com.pre.dojo.control;

/**
 * Classe responsável por representar a linha do log.
 * @author Marcus Vinícius
 * @since 21/04/2015 
 */
public class LogLine {
	
	private final int TIMESTAMP = 0;
	private final int EVENT = 1;
	
	private final int SUBJECT = 0;
	private final int SUBJECT_VERB = 1;
	private final int OBJECT1 = 2;
	private final int OBJECT1_VERB_PREPOSITION = 3;
	private final int OBJECT2 = 4;
	
	private final int MATCH_ID = 2;
	
	private String line;

	public LogLine(String line) {
		this.line = line;
	}
	
	public Boolean isMatchStart() {
		return getEvent().contains("started");
	}
	
	public Boolean isMatchEnd() {
		return getEvent().contains("ended");
	}
	
	public String getTimestamp() {
		return line.split(" - ")[TIMESTAMP];
	}
	
	public String getEvent() {
		return line.split(" - ")[EVENT];
	}
	
	public String getSubject() {
		return getEvent().split(" ")[SUBJECT];
	}
	
	public String getSubjectVerb() {
		return getEvent().split(" ")[SUBJECT_VERB];
	}
	
	public String getObject1() {
		return getEvent().split(" ")[OBJECT1];
	}
	
	public String getObject1VerbPreposition() {
		return getEvent().split(" ")[OBJECT1_VERB_PREPOSITION];
	}
	
	public String getObject2() {
		return getEvent().split(" ")[OBJECT2];
	}
	
	public String getMatchId() {
		return getEvent().split(" ")[MATCH_ID];
	}

}
