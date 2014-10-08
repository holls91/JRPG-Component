package characters.attributes;

import characters.PlayableCharacter;

/**
 * I Bonus sono vantaggi, in termini di valori numerici, che possono essere assegnati a un Attributo.
 * @author Simona Francini
 *
 */
/*
 * Sottoclasse di AbstractAttribute. Definisce i Bonus da appicare agli Attributi.
 */
public abstract class Bonus extends AbstractAttribute{

	
	public Bonus(String name, int baseValue, double baseMolt, Enum<? extends Enum<?>> type) {
		super(name, baseValue, baseMolt, type);
	}
	
	/**
	 * Questo metodo permette di aggiungere un certo Bonus a un determinato Attributo del PErsonaggio
	 * @param pers Il Personaggio di cui si vuole modificare l'Attributo
	 */
	public abstract void addBonusToAttribute(PlayableCharacter pers);
	
	/**
	 * Questo metodo permette di rimuovere un certo Bonus a un determinato Attributo del PErsonaggio
	 * @param pers Il Personaggio di cui si vuole modificare l'Attributo
	 */
	public abstract void removeBonusToAttribute(PlayableCharacter pers);

	public String toString(){
		return "Bonus applicato all'attributo "+getType()+"; Valore base: "+getBaseValue()+"; Moltiplicatore base: "+getBaseMolt();
	}
}
