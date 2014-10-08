package characters.job;

import characters.moveset.Moveset;
import strategy.formula.GrowingFormula;

/**
 * Questa classe implementa il Job System, ovvero le classi che il Personaggio
 * può assumere e che modificano le abilità disponibili e la velocità di
 * crescita di alcune statistiche.
 * 
 * @author Simona Francini
 * 
 */
public class Job {

	/*
	 * Ogni Job ha il suo modo di modificare la crescita del personaggio e può
	 * farlo tramite la definizione di una sua GrowingFormula (secondo il
	 * pattern Strategy).
	 */
	private GrowingFormula formula;
	private Moveset moveset;
	/*
	 * Il tipo di Job adesso è generico, in modo che ogni utente possa definire
	 * la sua lista tramite Enum.
	 */
	private Enum<? extends Enum<?>> type;

	public Job(Moveset moveset, Enum<? extends Enum<?>> type, GrowingFormula formula) {
		this.moveset = moveset;
		this.type = type;
		this.formula = formula;
	}

	public Job() {
		moveset = new Moveset();
	}

	/**
	 * Restituisce il MoveSet relativo a questo specifico Job.
	 * 
	 * @return Il MoveSet relativo a questo specifico Job
	 */
	public Moveset getMoveset() {
		return moveset;
	}

	/**
	 * Permette di settare un nuovo MoveSet per questo specifico Job.
	 * 
	 * @param moveset
	 *            Il nuovo MoveSet per questo specifico Job
	 */
	public void setMoveset(Moveset moveset) {
		this.moveset = moveset;
	}

	/**
	 * Restituisce il tipo di Job, preso dalla classe JobType, che contiene
	 * l'elenco di tutti i Job possibili.
	 * 
	 * @return Il tipo di Job di questo specifico Job
	 */
	public Enum<? extends Enum<?>> getType() {
		return type;
	}

	/**
	 * Permette di settare un nuovo tipo di Job a questo specifico Job.
	 * 
	 * @param type
	 *            Il nuovo tipo di Job
	 */
	public void setType(Enum<? extends Enum<?>> type) {
		this.type = type;
	}

	/**
	 * @return the formula
	 */
	public GrowingFormula getFormula() {
		return formula;
	}

	/**
	 * @param formula
	 *            the formula to set
	 */
	public void setFormula(GrowingFormula formula) {
		this.formula = formula;
	}

}
