package characters.abilities;

import characters.PlayableCharacter;
import characters.menuoptions.MenuOption;

/**
 * Questa classe astratta definisce una generica abilità, con nome, livello,
 * punti ottenuti e punti da ottenere, costo, probabilità di riuscita, mossa
 * sicura o meno e il tipo. Verrà estesa da alcune sottoclassi che ne
 * definiranno meglio il comportamento.
 * 
 * @author Simona Francini
 * 
 */
/*
 * Le abilità sono strutturate come un Composite, quindi abbiamo questa classe
 * che è la superclasse, che verrà poi estesa da foglie e da un "contenitore" di
 * AbstractAbility.
 */
public abstract class AbstractAbility extends MenuOption {

	/*
	 * Variabili private che possono essere manipolate con getters e setters
	 */
	private int ID, level, progressPoints, abilityPoints, cost;
	private static int ID_STATIC;
	private double probability;
	private boolean sureHit;
	/*
	 * La variabile type ha un Enum generico, che potrà essere definito
	 * dall'utente finale.
	 */
	private Enum<? extends Enum<?>> type;

	// private LoadScript script;

	public AbstractAbility(Enum<? extends Enum<?>> type) {
		ID = ID_STATIC++;
		this.type = type;
		this.probability = 1;
		this.sureHit = false;
	}

	/**
	 * Questo metodo definisce il comportamento dell'Abilità.
	 * 
	 * @param source
	 *            Colui che richiama l'Abilità
	 * @param targets
	 *            Il target su cui verrà eseguita l'Abilità
	 */
	/*
	 * Metodo che potrà essere riscritto manualmente oppure tramite l'ausilio di
	 * uno strategy.
	 * 
	 * @see personaggi.options.MenuOption#esegui(personaggi.PlayableCharacter,
	 * personaggi.PlayableCharacter[])
	 */
	public abstract void execute(PlayableCharacter source,
			PlayableCharacter... targets);


	/**
	 * Restituisce l'ID dell'Abilità.
	 * 
	 * @return L'ID dell'Abilità
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Permette di settare l'ID dell'Abilità
	 * 
	 * @param name
	 *            Il nuovo ID dell'Abilità
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Restituisce il livello in cui viene appresa l'Abilità.
	 * 
	 * @return Il livello in cui viene appresa l'Abilità
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Permette di settare il livello in cui viene appresa l'Abilità.
	 * 
	 * @param name
	 *            Il nuovo livello in cui viene appresa l'Abilità
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Restituisce i punti accumulati per l'Abilità.
	 * 
	 * @return I punti accumulati per l'Abilità
	 */
	public int getProgressPoints() {
		return progressPoints;
	}

	/**
	 * Permette di settare i punti accumulati per l'Abilità.
	 * 
	 * @param progressPoints
	 *            I punti da settare per l'Abilità
	 */
	public void setProgressPoints(int progressPoints) {
		this.progressPoints = progressPoints;
	}

	/**
	 * Restituisce i punti necessari per considerare appresa l'Abilità.
	 * 
	 * @return I punti necessari per considerare appresa l'Abilità
	 */
	public int getAbilityPoints() {
		return abilityPoints;
	}

	/**
	 * Permette di settare i punti necessari per considerare appresa l'Abilità.
	 * 
	 * @param abilityPoints
	 *            I punti necessari per considerare appresa l'Abilità
	 */
	public void setAbilityPoints(int abilityPoints) {
		this.abilityPoints = abilityPoints;
	}

	/**
	 * Restituisce il costo dell'Abilità.
	 * 
	 * @return Il costo dell'Abilità
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Permette di settare il costo dell'Abilità.
	 * 
	 * @param costo
	 *            Il costo dell'Abilità
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * Restituisce la probabilità con cui verrà eseguita l'Abilità.
	 * 
	 * @return La probabilità con cui verrà eseguita l'Abilità
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * Permette di settare la probabilità con cui verrà eseguita l'Abilità.
	 * 
	 * @param probability
	 *            La probabilità con cui verrà eseguita l'Abilità
	 */
	public void setProbability(double probability) {
		this.probability = probability;
	}

	/**
	 * Il metodo ci indica se l'Abilità verrà eseguita sicuramente (anche in
	 * caso di bassa precisione o Cecità) oppure no.
	 * 
	 * @return True se l'Abilità andrà a segno sicuramente, false altrimenti
	 */
	public boolean isSureHit() {
		return sureHit;
	}

	/**
	 * Permette di decidere se l'Abilità andrà sicuramente a segno anche in
	 * condizioni sfavorevoli (bassa precisione o Cecità).
	 * 
	 * @param colpoSicuro
	 *            True se l'Abilità verrà eseguita sicuramente, false altrimenti
	 */
	public void setSureHit(boolean sureHit) {
		this.sureHit = sureHit;
	}

	/**
	 * Restituisce il tipo dell'Abilità.
	 * 
	 * @return Il tipo dell'Abilità
	 */
	public Enum<? extends Enum<?>> getType() {
		return type;
	}

	/**
	 * Permette di settare un nuovo tipo di Abilità
	 * 
	 * @param type
	 *            Il nuovo tipo dell'Abilità
	 */
	public void setType(Enum<? extends Enum<?>> type) {
		this.type = type;
	}

	public String toString() {
		return getName();
	}

}
