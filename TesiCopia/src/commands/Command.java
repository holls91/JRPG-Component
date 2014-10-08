package commands;

import characters.PlayableCharacter;
import characters.menuoptions.MenuOption;

/**
 * Questa classe rappresenta tutto ci� che � possibile trovare nel men�.
 * 
 * @author Simona Francini
 * 
 */
/*
 * La parte dei Comandi � strutturata secondo il pattern Command e l'ho
 * utilizzato per creare le voci del men�.
 */
public abstract class Command {

	protected MenuOption option;
	private PlayableCharacter pc;
	/*
	 * Variabile per salvare gli input dell'utente.
	 */
	protected int[] level;

	public Command(PlayableCharacter pc) {
		this.pc = pc;
		level = new int[10];
	}

	/**
	 * Questo metodo permette di definire il comportamento della voce del men�.
	 */
	/*
	 * Questo metodo rappresenta una sorta di Template: � gi� strutturato e
	 * l'utente finale dovr� solo riscrivere playerChoose e cpuChoose.
	 */
	public final boolean execute() {
		if (pc.getTeam().getFlag() == 0)
			return playerChoose();
		else
			return cpuChoose();
	}

	/**
	 * Questo metodo restituisce il nome del Comando
	 * 
	 * @return Il nome del Comando
	 */
	public abstract String getName();

	/**
	 * Questo metodo restituisce il tipo di mossa che dovr� essere eseguito.
	 * 
	 * @return Il tipo di mossa che dovr� essere eseguito
	 */
	public MenuOption getMove() {
		return option;
	}

	/**
	 * @return the pc
	 */
	public PlayableCharacter getPc() {
		return pc;
	}

	/*
	 * Questi due metodi restituiscono true se � stata scelta una mossa, false altrimenti.
	 */
	abstract boolean playerChoose();

	abstract boolean cpuChoose();
}
