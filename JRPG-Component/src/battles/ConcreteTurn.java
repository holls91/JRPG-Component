package battles;

import java.util.Collections;
import java.util.TreeMap;

import characters.Enemy;
import characters.Hero;
import characters.PlayableCharacter;
import characters.Team;
import characters.attributes.StatType;


/**
 * Implementazione concreta di un Turno. In questa versione, i turni vengono
 * decisi in base alla velocità dei partecipanti allo scontro e viene seguita la
 * classica implementazione a turni.
 * 
 * @author Simona Francini
 * 
 */
public class ConcreteTurn extends Turn {

	private int max_stat;
	private double turns;
	private TreeMap<Double, PlayableCharacter> turnMap;
	int length, lengthTurn;

	public ConcreteTurn(Team<Hero> personaggi, Team<Enemy> nemici) {
		super(personaggi, nemici);
		int contAlleati = personaggi.size();
		int contNemici = nemici.size();
		lengthTurn = contNemici + contAlleati;
		length = lengthTurn;
	}

	public void manageTurn() {
		if (length == lengthTurn)
			nextTurn();
	}

	/**
	 * Questo metodo inizializza la lista dei turni, ordinando i Personaggi in
	 * base alla loro velocità, più un valore random per evitare sovrapposizioni
	 * in caso di Personaggi con ugual velocità.
	 */
	protected void initialize() {
		max_stat = 256;
		turns = Integer.MAX_VALUE - max_stat;
		turnMap = new TreeMap<Double, PlayableCharacter>(
				Collections.reverseOrder());
		for (PlayableCharacter pc : heroes)
			turnMap.put(
					turns + pc.getAttribute(StatType.Velocita).getValue()
							+ Math.random(), pc);
		for (PlayableCharacter pc : enemies)
			turnMap.put(
					turns + pc.getAttribute(StatType.Velocita).getValue()
							+ Math.random(), pc);
	}

	/**
	 * Questo metodo restituisce il prossimo Personaggio che potrà scegliere la
	 * sua Mossa.
	 * 
	 * @return Il prossimo Personaggio che potrà scegliere la sua Mossa
	 */
	public PlayableCharacter next() {
		do {
			source = turnMap.pollFirstEntry().getValue();
		} while (source.getStatistics().getAttr(StatType.HP).getCurrentValue() <= 0); 
		return source;
	}

	/**
	 * Questo metodo ci comunica che un Personaggio ha eseguito il suo turno e
	 * che quindi avrà una priorità più bassa rispetto agli altri partecipanti.
	 */
	protected void nextTurn() {
		turns -= max_stat;
	}

	public void finishTurn() {
		length--;
		if (length == 0) {
			length = lengthTurn;
		}
		reput(source);
	}

	/**
	 * Questo metodo permette di inserire nuovamente un Personaggio nella lista
	 * dei turni, una volta eseguita la sua Mossa.
	 * 
	 * @param pers
	 */
	protected void reput(PlayableCharacter pers) {
		turnMap.put(turns + pers.getAttribute(StatType.Velocita).getValue()
				+ Math.random(), pers);
	}
}
