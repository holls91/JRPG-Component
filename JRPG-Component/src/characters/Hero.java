package characters;

import java.util.EnumMap;

import characters.job.Job;

import strategy.formula.GrowingFormula;

/**
 * Questa classe rappresenta i Personaggi che sono direttamente controllabili dal giocatore. Contiene metodi per confermare o
 * rimuovere un Equip e metodi per gestire l'esperienza e la crescita del Personaggio.
 * @author Simona Francini
 *
 */
public class Hero extends PlayableCharacter{

	/*
	 * La crescita dell'Eroe è regolata da uno Strategy, GrowingFormula. 
	 */
	private GrowingFormula formula;
	private Job currentJob;	
	private EnumMap<? extends Enum<?>, Job> jobs;
	
	public Hero(String name) {
		super(name);
	//	script.runScriptFunction("create", this);
	}

	/**
	 * Questo metodo permettere di cambiare Job, quindi ne acquisisce le abilità relative e modifica anche le statistiche
	 * e la velocità di crescita delle stesse.
	 * @param jobType Il Job che si vuole assegnare
	 */
	public void confirmJob(Enum<? extends Enum<?>> jobType){
		this.currentJob = jobs.get(jobType);
		this.formula = currentJob.getFormula();
		this.setMoveset(currentJob.getMoveset());
	}
	
	/**
	 * Questo metodo aggiunge una certa quantità di esperienza a quella già posseduta dall'Eroe.
	 * @param exp La quantità di esperienza che si vuole aggiungere
	 */
	public void addExperience(int exp){
		setExperience(getExperience()+exp);
	}
	
	/**
	 * Questo metodo controlla se il personaggio deve salire di livello. Calcola quanti sarebbero gli exp necessari per salire al livello
	 * successivo e controlla se gli exp attuali sono sufficienti: se lo sono, aumenta il livello, aggiorna le statistiche
	 * e calcola quanti exp sono necessari per salire al livello ancora successivo. Questa struttura si è resa necessaria 
	 * nel caso il personaggio dovesse salire di più livelli in una sola volta.
	 */
	/*
	 * Utilizzo dello strategy: con questo metodo, lo strategy controlla se il personaggio deve in qualche modo crescere.
	 * Non è indicato, a priori, nessun metodo di crescita (per livelli o volta volta): lo dovrà definire lo strategy.
	 */
	public void checkGrowth(){
		currentJob.getFormula().grow(this);
	}

	/**
	 * Restituisce la lista dei Jobs per questo Personaggio
	 * @return La lista dei Jobs per questo Personaggio
	 */
	public EnumMap<? extends Enum<?>, Job> getJobs() {
		return jobs;
	}

	/**
	 * Permette di settare una nuova lista di Jobs per questo Personaggio.
	 * @param jobs La nuova lista di Jobs per questo Personaggio
	 */
	public void setJobs(EnumMap<? extends Enum<?>, Job> jobs) {
		this.jobs = jobs;
	}

	/**
	 * Restituisce il Job corrente per questo personaggio.
	 * @return Il Job corrente per questo personaggio
	 */
	public Job getCurrentJob() {
		return currentJob;
	}

	/**
	 * Permette di settare un nuovo Job per questo personaggio.
	 * @param currentJob Il nuovo Job per questo personaggio
	 */
	public void setCurrentJob(Job currentJob) {
		this.currentJob = currentJob;
	}
	
	public Job getSpecificJob(Enum<? extends Enum<?>> jobType){
		return jobs.get(jobType);
	}

	/**
	 * @return the formula
	 */
	public GrowingFormula getFormula() {
		return formula;
	}

	/**
	 * @param formula the formula to set
	 */
	public void setFormula(GrowingFormula formula) {
		this.formula = formula;
	}

}
