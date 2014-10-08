package characters.moveset;

import showable.Showable;
import characters.abilities.AbstractAbility;

/**
 * Questa interfaccia rappresenta un Moveset astratto e contiene alcuni metodi per lavorare su di esso.
 * @author Simona Francini
 *
 */
/*
 * Ho optato per un'interfaccia per la questione degli Enum: se avessi definito in questa classe
 * una Map con chiave un Enum generico, non avrei potuto utilizzarla per effettuare l'operazione di put.
 */

public interface AbstractMoveset extends Showable, Iterable<Enum<?>>{

	/*
	 * Per il getter e il setter ho imposto io una struttura, anche se l'Enum utilizzabile è a scelta dell'utente.
	 */
	public Enum<? extends Enum<?>> getTypeFromInt(int category);
	public void addAbility(AbstractAbility ability);
	public void removeAbility(AbstractAbility ability);
	public AbstractAbility getAbility(Enum<? extends Enum<?>> type, Integer abilityType);
	public AbstractAbility getRandomAbility();

}
