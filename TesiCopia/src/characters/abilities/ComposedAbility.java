package characters.abilities;

import java.util.ArrayList;

import characters.PlayableCharacter;


/**
 * Questa classe rappresenta un'Abilità composta dalle sottoclassi di AbstractAbility.
 * @author Simona Francini
 *
 */
public class ComposedAbility extends AbstractAbility {

	private ArrayList<AbstractAbility> abilityList;
	
	public ComposedAbility(ArrayList<AbstractAbility> abilityList, Enum<? extends Enum<?>> type){
		super(type);
		this.abilityList = abilityList;
	}
	
	public ComposedAbility(Enum<? extends Enum<?>> type){
		super(type);
		this.abilityList = new ArrayList<AbstractAbility>();
	}
	
	/*
	 * L'implementazione di questo metodo ricalca quello di un Composite, nel caso di oggetto "contenitore".
	 * @see personaggi.abilità.AbstractAbility#esegui(personaggi.PlayableCharacter, personaggi.PlayableCharacter[])
	 */
	@Override
	public void execute(PlayableCharacter source, PlayableCharacter... targets) {
		for(AbstractAbility ability : abilityList)
			ability.execute(source, targets);
	}

	public void add(AbstractAbility ability){
		this.abilityList.add(ability);
	}
	
	public ArrayList<AbstractAbility> getAbilityList() {
		return abilityList;
	}

	public void setAbilityList(ArrayList<AbstractAbility> abilityList) {
		this.abilityList = abilityList;
	}

}
