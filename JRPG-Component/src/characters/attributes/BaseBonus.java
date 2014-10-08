package characters.attributes;

import characters.PlayableCharacter;

/**
 * Questa classe rappresenta i Bonus che vengono applicati al valore di base dell'Attributo.
 * @author Simona Francini
 *
 */
public class BaseBonus extends Bonus {

	public BaseBonus(String name, int baseValue, double baseMolt, Enum<? extends Enum<?>> type) {
		super(name, baseValue, baseMolt, type);
	}
	
	public void addBonusToAttribute(PlayableCharacter pers){
		pers.getAttribute(getType()).addBaseBonus(this);
	}
	
	public void removeBonusToAttribute(PlayableCharacter pers){
		pers.getAttribute(getType()).removeBaseBonus(this);
	}

}
