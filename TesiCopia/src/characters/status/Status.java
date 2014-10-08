package characters.status;

/**
 * Questa classe rappresenta l'alterazione di stato che un personaggio può
 * subire.
 * 
 * @author Simona Francini
 * 
 */
public class Status {

	private String name;
	/*
	 * Per queste due variabili non è specificato l'Enum dal quale prendere i
	 * valori, in modo da lasciare più libertà all'utente.
	 */
	private Enum<? extends Enum<?>> type;
	private Enum<? extends Enum<?>> statType;
	private int duration;
	private double percent;
	private boolean skipTurn;
	private boolean choosableCommand;
	/*
	 * Lo status ha uno strategy, che permette di definire il comportamento.
	 */
	private StatusBehavior behavior;

	public Status(Enum<? extends Enum<?>> type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Il tipo di Status (il nome)
	 */
	public Enum<? extends Enum<?>> getType() {
		return type;
	}

	public void setType(Enum<? extends Enum<?>> type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Questo metodo ci dice se lo Status permette comunque di fare una mossa,
	 * anche se con target casuale. Normalmente, sarà settato a true in caso di
	 * status Pietra e Morte.
	 * 
	 * @return True se il giocatore non può eseguire alcuna mossa, nemmeno
	 *         casuale; false altrimenti
	 */
	public boolean isSkipTurn() {
		return skipTurn;
	}

	public void setSkipTurn(boolean skipTurn) {
		this.skipTurn = skipTurn;
	}

	/**
	 * Questo metodo ci dice se lo Status permette al giocatore di selezionare
	 * una voce dal menù di battaglia. Normalmente, sarà settato a false in caso
	 * di status Berserk, Confusione, Pietra e Morte.
	 * 
	 * @return True se il giocatore può scegliere manualmente il comando da
	 *         selezionare, false altrimenti
	 */
	public boolean isChoosableCommand() {
		return choosableCommand;
	}

	public void setChoosableCommand(boolean choosableCommand) {
		this.choosableCommand = choosableCommand;
	}

	/**
	 * @return the behavior
	 */
	public StatusBehavior getBehavior() {
		return behavior;
	}

	/**
	 * @param behavior
	 *            the behavior to set
	 */
	public void setBehavior(StatusBehavior behavior) {
		this.behavior = behavior;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	/*
	 * Il tipo di Statistica sul quale influirà (eventualmente) lo Status.
	 */
	public Enum<? extends Enum<?>> getStatType() {
		return statType;
	}

	public void setStatType(Enum<? extends Enum<?>> statType) {
		this.statType = statType;
	}

}
