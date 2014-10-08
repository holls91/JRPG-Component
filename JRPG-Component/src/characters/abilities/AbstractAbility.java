package characters.abilities;

import characters.PlayableCharacter;
import characters.menuoptions.MenuOption;

/**
 * Questa classe astratta definisce una generica abilit�, con nome, livello,
 * punti ottenuti e punti da ottenere, costo, probabilit� di riuscita, mossa
 * sicura o meno e il tipo. Verr� estesa da alcune sottoclassi che ne
 * definiranno meglio il comportamento.
 * 
 * @author Simona Francini
 * 
 */
/*
 * Le abilit� sono strutturate come un Composite, quindi abbiamo questa classe
 * che � la superclasse, che verr� poi estesa da foglie e da un "contenitore" di
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
	 * La variabile type ha un Enum generico, che potr� essere definito
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
	 * Questo metodo definisce il comportamento dell'Abilit�.
	 * 
	 * @param source
	 *            Colui che richiama l'Abilit�
	 * @param targets
	 *            Il target su cui verr� eseguita l'Abilit�
	 */
	/*
	 * Metodo che potr� essere riscritto manualmente oppure tramite l'ausilio di
	 * uno strategy.
	 * 
	 * @see personaggi.options.MenuOption#esegui(personaggi.PlayableCharacter,
	 * personaggi.PlayableCharacter[])
	 */
	public abstract void execute(PlayableCharacter source,
			PlayableCharacter... targets);


	/**
	 * Restituisce l'ID dell'Abilit�.
	 * 
	 * @return L'ID dell'Abilit�
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Permette di settare l'ID dell'Abilit�
	 * 
	 * @param name
	 *            Il nuovo ID dell'Abilit�
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Restituisce il livello in cui viene appresa l'Abilit�.
	 * 
	 * @return Il livello in cui viene appresa l'Abilit�
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Permette di settare il livello in cui viene appresa l'Abilit�.
	 * 
	 * @param name
	 *            Il nuovo livello in cui viene appresa l'Abilit�
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Restituisce i punti accumulati per l'Abilit�.
	 * 
	 * @return I punti accumulati per l'Abilit�
	 */
	public int getProgressPoints() {
		return progressPoints;
	}

	/**
	 * Permette di settare i punti accumulati per l'Abilit�.
	 * 
	 * @param progressPoints
	 *            I punti da settare per l'Abilit�
	 */
	public void setProgressPoints(int progressPoints) {
		this.progressPoints = progressPoints;
	}

	/**
	 * Restituisce i punti necessari per considerare appresa l'Abilit�.
	 * 
	 * @return I punti necessari per considerare appresa l'Abilit�
	 */
	public int getAbilityPoints() {
		return abilityPoints;
	}

	/**
	 * Permette di settare i punti necessari per considerare appresa l'Abilit�.
	 * 
	 * @param abilityPoints
	 *            I punti necessari per considerare appresa l'Abilit�
	 */
	public void setAbilityPoints(int abilityPoints) {
		this.abilityPoints = abilityPoints;
	}

	/**
	 * Restituisce il costo dell'Abilit�.
	 * 
	 * @return Il costo dell'Abilit�
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Permette di settare il costo dell'Abilit�.
	 * 
	 * @param costo
	 *            Il costo dell'Abilit�
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * Restituisce la probabilit� con cui verr� eseguita l'Abilit�.
	 * 
	 * @return La probabilit� con cui verr� eseguita l'Abilit�
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * Permette di settare la probabilit� con cui verr� eseguita l'Abilit�.
	 * 
	 * @param probability
	 *            La probabilit� con cui verr� eseguita l'Abilit�
	 */
	public void setProbability(double probability) {
		this.probability = probability;
	}

	/**
	 * Il metodo ci indica se l'Abilit� verr� eseguita sicuramente (anche in
	 * caso di bassa precisione o Cecit�) oppure no.
	 * 
	 * @return True se l'Abilit� andr� a segno sicuramente, false altrimenti
	 */
	public boolean isSureHit() {
		return sureHit;
	}

	/**
	 * Permette di decidere se l'Abilit� andr� sicuramente a segno anche in
	 * condizioni sfavorevoli (bassa precisione o Cecit�).
	 * 
	 * @param colpoSicuro
	 *            True se l'Abilit� verr� eseguita sicuramente, false altrimenti
	 */
	public void setSureHit(boolean sureHit) {
		this.sureHit = sureHit;
	}

	/**
	 * Restituisce il tipo dell'Abilit�.
	 * 
	 * @return Il tipo dell'Abilit�
	 */
	public Enum<? extends Enum<?>> getType() {
		return type;
	}

	/**
	 * Permette di settare un nuovo tipo di Abilit�
	 * 
	 * @param type
	 *            Il nuovo tipo dell'Abilit�
	 */
	public void setType(Enum<? extends Enum<?>> type) {
		this.type = type;
	}

	public String toString() {
		return getName();
	}

}
