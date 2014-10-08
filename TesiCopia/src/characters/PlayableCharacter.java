package characters;

import java.util.ArrayList;

import characters.attributes.ConcreteAttribute;
import characters.equip.Equip;
import characters.equiplist.EquipList;
import characters.equiplist.MyEquipList;
import characters.moveset.AbstractMoveset;
import characters.moveset.Moveset;
import characters.statistics.MyStatistics;
import characters.statistics.Statistics;
import characters.status.Status;


import commands.Command;

/**
 * Questa classe rappresenta quei Personaggi che hanno la possibilità di partecipare a uno Scontro, sia che siano controllati
 * dal giocatore, sia dal computer. Contengono quindi statistiche, equip, moveset, inventario, esperienza e un Team di appartenenza.
 * @author Simona Francini
 *
 */
public abstract class PlayableCharacter extends Character{

	/*
	 * Variabili private che possono essere manipolate con getters e setters
	 */
	private int experience, level;
	private Statistics statistics;
	private EquipList equip;
	private AbstractMoveset moveset;
	private Team<? extends PlayableCharacter> team;
	private ArrayList<Command> commandList;
	private ArrayList<Status> statusList;
	
	public PlayableCharacter(String name){
		super(name);
		statistics = new MyStatistics();
		equip = new MyEquipList();
		moveset = new Moveset();
		commandList = new ArrayList<>();
		statusList = new ArrayList<>();
		experience = 0;
		level = 1;
	}

	/**
	 * @return the moveset
	 */
	public AbstractMoveset getMoveset() {
		return moveset;
	}

	/**
	 * @param moveset the moveset to set
	 */
	public void setMoveset(AbstractMoveset moveset) {
		this.moveset = moveset;
	}

	/**
	 * @return the equip
	 */
	public EquipList getEquip() {
		return equip;
	}

	/**
	 * @param equip the equip to set
	 */
	public void setEquip(EquipList equip) {
		this.equip = equip;
	}

	public void confirmEquip(Equip equip){
		this.equip.confirmEquip(this, equip);
	}
	
	public void removeEquip(Equip equip){
		this.equip.removeEquip(this, equip);
	}
	
	/**
	 * Restituisce l'Attributo del Personaggio in questione.
	 * @param statType Il nome dell'Attributo che si vuole prendere, sulla base delle definizioni di StatType
	 * @return L'attributo del Personaggio
	 */
	public ConcreteAttribute getAttribute(Enum<? extends Enum<?>> statType){
		return statistics.getAttr(statType);
	}

	public Statistics getStatistics(){
		return statistics;
	}

	/**
	 * @param statistics the statistiche to set
	 */
	public void setStatistiche(Statistics statistics) {
		this.statistics = statistics;
	}

	/**
	 * Restituisce il livello corrente.
	 * @return Il livello corrente
	 */
	public int getLevel(){
		return level;
	}

	/**
	 * Permette di settare il livello del Personaggio
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Permette di ottenere l'esperienza attuale del Personaggio
	 * @return L'esperienza attuale del Personaggio
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * Permette di settare l'esperienza del Personaggio
	 * @param esperienza Il nuovo parametro dell'esperienza del Personaggio
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * Restituisce il Team di appartenenza del Personaggio
	 * @return Il Team di appartenenza del Personaggio
	 */
	public Team<? extends PlayableCharacter> getTeam() {
		return team;
	}
	
	/**
	 * Permette di settare il Team del Personaggio
	 * @param team Il Team da assegnare al Personaggio
	 */
	public void setTeam(Team<? extends PlayableCharacter> team) {
		this.team = team;
	}
	
	/**
	 * Questo metodo restituisce la lista dei comandi scelti dal giocatore (o settati di default).
	 * @return La lista di comandi del personaggio
	 */
	public ArrayList<Command> getCommandList() {
		return commandList;
	}

	/**
	 * Questo metodo permette di settare una nuova lista di comandi.
	 * @param listaComandi La nuova lista da settare
	 */
	public void setCommandList(ArrayList<Command> commandList) {
		this.commandList = commandList;
	}
	
	public ArrayList<Status> getStatusList() {
		return statusList;
	}

	public void setStatusList(ArrayList<Status> statusList) {
		this.statusList = statusList;
	}

	public String printCommands(){
		String out = "";
		for(int i = 0; i<commandList.size(); i++)
			out+="\n\t"+i+" = "+commandList.get(i).getName();
		return out;
	}


	public String toString(){
		return "Nome: "+getName();
	}
}
