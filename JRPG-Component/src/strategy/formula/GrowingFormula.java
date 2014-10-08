package strategy.formula;

import characters.PlayableCharacter;

/**
 * Questa interfaccia permette di definire alcuni metodi che regolano la crescita del personaggio.
 * @author Simona Francini
 *
 */
public interface GrowingFormula {

	/**
	 * Questo metodo calcola il livello a partire dagli exp posseduti.
	 * @param exp Esperienza posseduta
	 * @return Il livello corrispondente
	 */
	public int calculateLevelFromExp(int exp);
	/**
	 * Questo metodo calcola i punti esperienza posseduti a partire dal livello.
	 * @param level Livello corrente
	 * @return Esperienza posseduta
	 */
	public int calculateExpFromLevel(int level);
	/**
	 * Questo metodo calcola il valore delle statistiche correnti a partire dai punti esperienza.
	 * @param pc Il personaggio di cui si vuole aggiornare le stat
	 */
	public void calculateStatsFromExp(PlayableCharacter pc);
	/**
	 * Questo metodo calcola il valore di una singola statistica a partire dai punti esperienza.
	 * @param pc Il personaggio di cui si vuole calcolare la statistica
	 * @param type Il tipo di statistica da calcolare
	 */
	void calculateStatFromExp(PlayableCharacter pc, Enum<? extends Enum<?>> type);
	/**
	 * Questo metodo calcola il valore di una statistica secondo una certa formula.
	 * @param pc Il personaggio di cui si vuole calcolare la statistica
	 * @param type Il tipo di statistica da calcolare
	 * @return Il valore della statistica secondo la formula seguita
	 */
	int statFormula(PlayableCharacter pc, Enum<? extends Enum<?>> type);
	/**
	 * Questo metodo aggiorna le statistiche del personaggio secondo una struttura definita dall'utente (es. Sistema a livelli).
	 * @param pc Il personaggio che si vuole far crescere
	 */
	public void grow(PlayableCharacter pc);
	
}
