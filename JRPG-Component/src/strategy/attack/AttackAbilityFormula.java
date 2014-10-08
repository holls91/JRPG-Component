package strategy.attack;

import characters.PlayableCharacter;
import characters.abilities.DamageAbility;
import characters.attributes.StatType;

/**
 * Implementazione concreta di un'Abilità che arreca danno.
 * @author Simona Francini
 *
 */
public class AttackAbilityFormula implements AbstractAttackFormula{

	@Override
	public void execute(PlayableCharacter source, DamageAbility ability, PlayableCharacter... targets) {
		int abilityDamage = ability.getDamage();
		double critic = ability.getCritic();
		for(PlayableCharacter pc : targets){
			int health = pc.getAttribute(StatType.HP).getCurrentValue();
			int damage = (int) (((source.getStatistics().getAttr(StatType.Attacco_Fisico).getCurrentValue()*abilityDamage/
					50*pc.getStatistics().getAttr(StatType.Difesa_Fisica).getCurrentValue())*(source.getLevel()/5)+1)+1);
			double randomCritic = Math.random();
			if(randomCritic<critic)
				damage*=2;
			pc.getAttribute(StatType.HP).setCurrentValue(health-damage);
		}
	}

}
