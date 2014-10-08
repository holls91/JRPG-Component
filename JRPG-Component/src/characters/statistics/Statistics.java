package characters.statistics;

import characters.attributes.ConcreteAttribute;

public interface Statistics extends Iterable<Enum<?>>{

	/*
	 * Stesso commento che ho messo a ListaEquip, che riporto: Avrei preferito
	 * che le Statistiche avessero una lista (o Map): il problema è che, per ciò
	 * che concerne la chiave, avrei dovuto mettere un generico tipo di chiave
	 * che estende Enum, che Java mi riconosceva come tipo "null" e mi impediva
	 * quindi di effettuare le operazioni di inserimento nella lista/Map. Per
	 * questo sono stata costretta a definire la lista/Map all'interno della
	 * sottoclasse, invece che qui nella superclasse.
	 */

	/*
	 * Ho riscritto anche qui il metodo put in modo tale che l'utente possa fare
	 * statistiche.put(attributo), senza preoccuparsi di quale sia l'Enum scelto
	 * come chiave della lista.
	 */
	public void put(ConcreteAttribute attr);
	public ConcreteAttribute getAttr(Enum<? extends Enum<?>> statType);

}
