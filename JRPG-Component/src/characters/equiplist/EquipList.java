package characters.equiplist;

import showable.Showable;
import characters.PlayableCharacter;
import characters.equip.Equip;

/*
 * Idealmente, se si volesse rendere l'Equip una voce del menù, ci sono a disposizione i metodi di stampa, forniti dall'interfaccia Mostrabile.
 */
public interface EquipList extends Showable, Iterable<Enum<?>> {

	/*
	 * Avrei preferito che la ListaEquip avesse, per l'appunto, una lista (o
	 * Map): il problema è che, per ciò che concerne la chiave, avrei dovuto
	 * mettere un generico tipo di chiave che estende Enum, che Java mi
	 * riconosceva come tipo "null" e mi impediva quindi di effettuare le operazioni
	 * di inserimento nella lista/Map. Per questo sono stata costretta a definire la
	 * lista/Map all'interno della sottoclasse, invece che qui nella superclasse.
	 */

	public void confirmEquip(PlayableCharacter pc, Equip equip);
	public void removeEquip(PlayableCharacter pc, Equip equip);
	public Equip getEquip(Enum<?> equip);


}
