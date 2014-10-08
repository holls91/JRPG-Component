package characters;

import characters.item.InventoryItem;

/**
 * Questa classe rappresenta quei Personaggi che, nello scontro, rappresenteranno gli Avversari.
 * @author Simona Francini
 *
 */
public class Enemy extends PlayableCharacter {
	
	/*
	 * Variabili private che possono essere manipolate con getters e setters
	 */
	private int givenExperience;
	private InventoryItem loot; //lista?
	private int money;
	
	public Enemy(String name) {
		super(name);
//		script.runScriptFunction("create", this);
	}

	/**
	 * Questo metodo restituisce l'esperienza che ogni Avversario donerà a fine scontro.
	 * @return L'esperienza che ogni Avversario donerà a fine scontro
	 */
	public int getGivenExperience(){
		return givenExperience;
	}
	
	/**
	 * Questo metodo restituisce il bottino che ogni Avversario donerà a fine scontro.
	 * @return Il bottino che ogni Avversario donerà a fine scontro
	 */
	public InventoryItem getLoot(){
		return loot;
	}
	
	/**
	 * Questo metodo restituisce il denaro che ogni Avversario donerà a fine scontro.
	 * @return Il denaro che ogni Avversario donerà a fine scontro
	 */
	public int getMoney(){
		return money;
	}

	/**
	 * @param experienceGiven the experienceGiven to set
	 */
	public void setGivenExperience(int givenExperience) {
		this.givenExperience = givenExperience;
	}

	/**
	 * @param loot the loot to set
	 */
	public void setLoot(InventoryItem loot) {
		this.loot = loot;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
