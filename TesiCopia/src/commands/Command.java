package commands;

import characters.PlayableCharacter;
import characters.menuoptions.MenuOption;

/**
 * Questa classe rappresenta tutto ciò che è possibile trovare nel menù.
 * 
 * @author Simona Francini
 * 
 */
/*
 * La parte dei Comandi è strutturata secondo il pattern Command e l'ho
 * utilizzato per creare le voci del menù.
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
	 * Questo metodo permette di definire il comportamento della voce del menù.
	 */
	/*
	 * Questo metodo rappresenta una sorta di Template: è già strutturato e
	 * l'utente finale dovrà solo riscrivere playerChoose e cpuChoose.
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
	 * Questo metodo restituisce il tipo di mossa che dovrà essere eseguito.
	 * 
	 * @return Il tipo di mossa che dovrà essere eseguito
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
	 * Questi due metodi restituiscono true se è stata scelta una mossa, false altrimenti.
	 */
	abstract boolean playerChoose();

	abstract boolean cpuChoose();
}
