package strategy.item;

import characters.PlayableCharacter;
import characters.item.Item;

/**
 * Superclasse dello Strategy che riguarda gli Oggetti. Permette di definire il comportamento qualora l'oggetto
 * venisse utilizzato.
 * @author Simona Francini
 *
 */
public abstract class AbstractItemStrategy {

	protected Item item;

	public AbstractItemStrategy(Item item){
		this.item = item;
	}
	
	public abstract void execute(PlayableCharacter source, PlayableCharacter... targets);


}
