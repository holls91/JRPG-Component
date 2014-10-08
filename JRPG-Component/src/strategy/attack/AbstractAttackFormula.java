package strategy.attack;

import characters.PlayableCharacter;
import characters.abilities.DamageAbility;

/**
 * Interfaccia del pattern Strategy. Definisce il comportamento di tutto ciò che arreca un danno.
 * @author Simona Francini
 *
 */
public interface AbstractAttackFormula {

	public void execute(PlayableCharacter source, DamageAbility ability, PlayableCharacter... targets);
}
