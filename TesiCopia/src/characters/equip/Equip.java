package characters.equip;

import java.util.HashSet;

import characters.attributes.Bonus;


/**
 * Questa classe rappresenta l'Equipaggiamento che verrà assegnato a ogni
 * personaggio. Ha un nome, un tipo (in riferimento alla parte del corpo in cui
 * è applicato) e una lista di Bonus.
 * 
 * @author Simona Francini
 * 
 */
public class Equip {

	private String name;
	/*
	 * Queste due variabili sono generiche (l'unica restrizione è che sono Enum,
	 * in modo da poter poi usare l'EnumMap) e permettono di definire, per ogni
	 * Equip, una categoria principale e una più specifica. Non è detto che
	 * siano usate entrambe.
	 */
	private Enum<? extends Enum<?>> type;
	private Enum<? extends Enum<?>> specificType;
	private HashSet<Bonus> bonusList;

	public Equip(String name, Enum<? extends Enum<?>> type) {
		this.name = name;
		this.type = type;
		bonusList = new HashSet<>();
	}

	/**
	 * Questo metodo aggiunge un Bonus all'Equip.
	 * 
	 * @param bonus
	 *            Bonus da aggiungere all'Equip
	 */
	public void add(Bonus bonus) {
		bonusList.add(bonus);
	}

	/**
	 * Questo metodo restituisce il nome dell'Equip
	 * 
	 * @return Il nome dell'Equip
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Questo metodo restituisce il tipo dell'Equip
	 * 
	 * @return Il tipo dell'Equip
	 */
	public Enum<? extends Enum<?>> getType() {
		return type;
	}

	/**
	 * Questo metodo permette di ottenere la lista dei Bonus relativi al singolo
	 * Equip
	 * 
	 * @return
	 */
	public HashSet<Bonus> getBonusList() {
		return bonusList;
	}

	/**
	 * @param listaBonus
	 *            the listaBonus to set
	 */
	public void setBonusList(HashSet<Bonus> bonusList) {
		this.bonusList = bonusList;
	}

	public String toString() {
		return "\n\tNome: " + name + ";\n\tTipo: " + type + ";\n\tBonus: "
				+ bonusList;
	}

	/**
	 * @return the specificType
	 */
	public Enum<? extends Enum<?>> getSpecificType() {
		return specificType;
	}

	/**
	 * @param specificType
	 *            the specificType to set
	 */
	public void setSpecificType(Enum<? extends Enum<?>> specificType) {
		this.specificType = specificType;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Enum<? extends Enum<?>> type) {
		this.type = type;
	}

}
