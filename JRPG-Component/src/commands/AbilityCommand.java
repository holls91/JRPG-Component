package commands;

import characters.PlayableCharacter;
import characters.abilities.AbstractAbility;
import characters.abilities.DamageAbility;
import characters.menuoptions.MenuOption;

/*
 * Sottoclasse di Command. Il costruttore prende in ingresso o un tipo (per creare un'abilità standard) o un'abilità
 * vera e propria, in modo da farla comparire nella voce di menù.
 */
public class AbilityCommand extends Command {

	public AbilityCommand(PlayableCharacter pc, Enum<? extends Enum<?>> type) {
		super(pc);
		option = new DamageAbility(type);
	}

	public AbilityCommand(PlayableCharacter pc, AbstractAbility ability) {
		super(pc);
		this.option = ability;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return option.getName();
	}

	@Override
	public MenuOption getMove() {
		// TODO Auto-generated method stub
		return option;
	}

	@Override
	public boolean playerChoose() {
		return true;
	}

	@Override
	public boolean cpuChoose() {
		return true;
	}

}
