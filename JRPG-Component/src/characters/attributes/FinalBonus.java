package characters.attributes;

import characters.PlayableCharacter;

/**
 * Questa classe rappresenta i Bonus che vengono applicati al valore finale dell'Attributo.
 * @author Simona Francini
 *
 */
public class FinalBonus extends Bonus{
	
	public FinalBonus(String name, int baseValue, double baseMolt, Enum<? extends Enum<?>> type) {
		super(name, baseValue, baseMolt, type);
	}
	
	public void addBonusToAttribute(PlayableCharacter pers){
		pers.getAttribute(getType()).addFinalBonus(this);
	}
	
	public void removeBonusToAttribute(PlayableCharacter pers){
		pers.getAttribute(getType()).removeFinalBonus(this);
	}
}
