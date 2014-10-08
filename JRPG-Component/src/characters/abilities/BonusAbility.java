package characters.abilities;

import java.util.ArrayList;

import characters.PlayableCharacter;
import characters.attributes.Bonus;


/**
 * Questa classe rappresenta quel genere di Abilit� che permette l'aumento o la diminuzione di certi Attributi.
 * @author Simona Francini
 *
 */
public class BonusAbility extends AbstractAbility{

	private ArrayList<Bonus> bonusList;
	
	public BonusAbility(ArrayList<Bonus> bonusList, Enum<? extends Enum<?>> type){
		super(type);
		this.bonusList = bonusList;
//		script.runScriptFunction("create", this);
	}
	
	/*
	 * Questo metodo ha un comportamento standard, per cui l'ho definito io.
	 * @see personaggi.abilit�.AbstractAbility#esegui(personaggi.PlayableCharacter, personaggi.PlayableCharacter[])
	 */
	@Override
	public void execute(PlayableCharacter source, PlayableCharacter... targets) {
		for(Bonus bonus : bonusList){
			for(PlayableCharacter target : targets)
				bonus.addBonusToAttribute(target);
		}
	}

	/**
	 * Restituisce la lista di Bonus applicati dall'Abilit�.
	 * @return La lista di Bonus applicati dall'Abilit�
	 */
	public ArrayList<Bonus> getBonusList() {
		return bonusList;
	}

	/**
	 * Permette di settare la lista dei Bonus che verranno applicati dall'Abilit�.
	 * @param listaBonus La lista dei Bonus che verranno applicati dall'Abilit�
	 */
	public void setBonusList(ArrayList<Bonus> bonusList) {
		this.bonusList = bonusList;
	}

}
