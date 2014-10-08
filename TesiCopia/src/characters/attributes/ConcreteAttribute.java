package characters.attributes;

import java.util.HashSet;

/**
 * Questa classe rappresenta l'Attributo concreto, che contiene una lista di Bonus base e Bonus finale, più un valore finale (ottenuto dopo
 * aver applicato tutti i bonus) e un valore corrente.
 * @author Simona Francini
 *
 */
public class ConcreteAttribute extends AbstractAttribute{

	private HashSet<AbstractAttribute> baseBonusList;
	private HashSet<AbstractAttribute> finalBonusList;
	private int finalValue, currentValue;
	
	public ConcreteAttribute(String name, int baseValue, double baseMolt, Enum<? extends Enum<?>> type) {
		super(name, baseValue, baseMolt, type);
		finalValue = baseValue;
		baseBonusList = new HashSet<>();
		finalBonusList = new HashSet<>();	
		currentValue = finalValue;
	}

//	/**
//	 * Restituisce la lista dei Bonus di base dell'Attributo
//	 * @return La lista dei Bonus di base dell'Attributo
//	 */
//	public HashSet<AbstractAttribute> getListaBonusBase() {
//		return listaBonusBase;
//	}
//
//	/**
//	 * Restituisce la lista dei Bonus finali dell'Attributo
//	 * @return La lista dei Bonus finali dell'Attributo
//	 */
//	public HashSet<AbstractAttribute> getListaBonusFinale() {
//		return listaBonusFinale;
//	}

	/**
	 * Questo metodo calcola il valore finale dell'Attributo una volta applicati i Bonus di base.
	 */
	protected void applyBonusBase(){
		int bonusBaseTemp = 0;
		double bonusMoltBaseTemp = 0;
		
		for(AbstractAttribute abs: baseBonusList){
			bonusBaseTemp += abs.getBaseValue();
			bonusMoltBaseTemp += abs.getBaseMolt();
		}
		
		finalValue += bonusBaseTemp;
		finalValue *= (1 + bonusMoltBaseTemp);
	}

	/**
	 * Questo metodo calcola il valore finale dell'Attributo una volta applicati i Bonus finali.
	 */
	protected void applyBonusFinale(){
		int finalBaseBonusTemp = 0;
		double finalBaseMoltTemp = 0;
		
		for(AbstractAttribute abs: finalBonusList){
			finalBaseBonusTemp += abs.getBaseValue();
			finalBaseMoltTemp += abs.getBaseMolt();
		}
		
		finalValue += finalBaseBonusTemp;
		finalValue *= (1 + finalBaseMoltTemp);
	}
	
	/**
	 * Questo metodo calcola il valore finale dell'Attributo, applicando prima i Bonus di base e poi quelli finali.
	 */
	/*
	 * Questo metodo segue il pattern Template.
	 */
	public final void applyBonus(){
		finalValue = getBaseValue();
		applyBonusBase();
		applyBonusFinale();
		setCurrentValue(Math.min(getValue(), currentValue));
	}
	
	/**
	 * Questo metodo restituisce il valore finale dell'Attributo, compreso di tutti i Bonus
	 * @return Il valore finale dell'Attributo, compreso di tutti i Bonus
	 */
	public int getValue(){
		return finalValue;
	}
	
	public void addBaseBonus(AbstractAttribute attribute){
		baseBonusList.add(attribute);
	}
	
	public void removeBaseBonus(AbstractAttribute bonusBase) {
		baseBonusList.remove(bonusBase);
	}
	
	public void addFinalBonus(AbstractAttribute attribute){
		finalBonusList.add(attribute);
	}

	public void removeFinalBonus(AbstractAttribute bonusFinale) {
		finalBonusList.remove(bonusFinale);
	}
	
	public String toString(){
		return this.getValue()+"";
	}
	
	/**
	 * Questo metodo restituisce il valore corrente dell'Attributo. Utile nel caso si stia parlando di Attributi che hanno un valore corrente
	 * e uno massimo, come nel caso dei Punti Vita.
	 * @return
	 */
	public int getCurrentValue(){
		return currentValue;
	}
	
	/**
	 * Questo metodo permette di settare un nuovo valore corrente, maggiore o uguale a 0.
	 * @param newCurrentValue Nuovo valore corrente.
	 */
	public void setCurrentValue(int newCurrentValue){
		this.currentValue = Math.max(0, newCurrentValue);
	}

}
