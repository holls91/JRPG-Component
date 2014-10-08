package characters.item;

import characters.PlayableCharacter;
import characters.menuoptions.MenuOption;
import strategy.item.AbstractItemStrategy;
import strategy.item.AttributeItemStrategy;


/**
 * Questa classe rappresenta la voce "Oggetti" del menù di battaglia. Contiene un nome e una descrizione dell'oggetto.
 * @author Simona Francini
 *
 */
public class Item  extends MenuOption{

	private String name, description;
	private int ID, quantityGiven, cost;
	private static int ID_STATIC = 0;
	private Enum<? extends Enum<?>> atr;
	/*
	 * Agli oggetti ho assegnato uno Strategy che definisce il loro comportamento quando utilizzati.
	 */
	private AbstractItemStrategy strategy;

	public Item(String name){
		this(name, "");
	}
	
	public Item(String name, String description){
		this.name = name;
		this.description = description;
		ID = ID_STATIC++;
		this.strategy = new AttributeItemStrategy(this);
	}

	public Item(String name, String description, int quantityGiven, Enum<? extends Enum<?>> atr){
		this(name, description);
		this.quantityGiven = quantityGiven;
		this.atr = atr;
		this.strategy = new AttributeItemStrategy(this);
	}

	/**
	 * Questo metodo restituisce il nome dell'Item.
	 * @return Il nome dell'Item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Questo metodo restituisce la descrizione dell'Item.
	 * @return La descrizione dell'Item
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return the quantityGiven
	 */
	public int getQuantityGiven() {
		return quantityGiven;
	}

	/**
	 * @param quantityGiven the quantityGiven to set
	 */
	public void setQuantityGiven(int quantityGiven) {
		this.quantityGiven = quantityGiven;
	}

	/**
	 * @return the atr
	 */
	public Enum<? extends Enum<?>> getAtr() {
		return atr;
	}

	/**
	 * @param atr the atr to set
	 */
	public void setAtr(Enum<? extends Enum<?>> atr) {
		this.atr = atr;
	}


	/**
	 * @return the strategy
	 */
	public AbstractItemStrategy getStrategy() {
		return strategy;
	}

	/**
	 * @param strategy the strategy to set
	 */
	public void setStrategy(AbstractItemStrategy strategy) {
		this.strategy = strategy;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public void execute(PlayableCharacter source,
			PlayableCharacter... targets) {
		strategy.execute(source, targets);
	}
	
	public String toString(){
		return "\n\tID:"+ID+"\n\tNome oggetto: "+name+",\n\tdescrizione: "+description;
	}

	
}
