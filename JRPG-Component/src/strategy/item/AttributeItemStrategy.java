package strategy.item;

import characters.PlayableCharacter;
import characters.attributes.ConcreteAttribute;
import characters.item.Item;

/**
 * Questa classe definisce il comportamento degli oggetti che agiscono sugli Attributi.
 * @author Simona Francini
 *
 */
public class AttributeItemStrategy extends AbstractItemStrategy{
	
	public AttributeItemStrategy(Item item) {
		super(item);
	}

	/**
	 * Questo metodo aumenta l'Attributo del Personaggio di una certa quantità. 
	 * @param character Il Personaggio su cui si vuole usare l'Item
	 */
	public void giveQuantity(PlayableCharacter character){
		giveQuantity(character.getAttribute(item.getAtr()));
	}

	/**
	 * Questo metodo aumenta di una certa quantità il valore base di un Attributo. Dopo che il valore base è stato aumentato, vengono
	 * ricalcolati tutti i Bonus associati all'Attributo.
	 * @param con
	 */
	protected void giveQuantity(ConcreteAttribute con){
		if(con.getType().name().equals("HP")){
			int tempQuantity = con.getCurrentValue()+item.getQuantityGiven();		
			con.setCurrentValue(Math.min(tempQuantity, con.getValue()));
		}
		else
			con.setBaseValue(con.getBaseValue()+item.getQuantityGiven());
		con.applyBonus();
	}

	@Override
	public void execute(PlayableCharacter source, PlayableCharacter... targets) {
		for(PlayableCharacter pc : targets)
			giveQuantity(pc);
		source.getTeam().getInventory().removeItem(item);
	}
	
	
}
