package characters;

import java.util.HashMap;
import java.util.Iterator;

import characters.inventory.Inventory;


/**
 * Il Team è rappresentato da un insieme di PlayableCharacter che partecipano
 * allo scontro, siano essi Eroi o Avversari. Possiede un flag che indica se il
 * Team è di Eroi (0) o di Avversari (1).
 * 
 * @author Simona Francini
 * 
 * @param <K>
 *            Classe che estende PlayableCharacter
 */
public class Team<K extends PlayableCharacter> implements Iterable<K> {

	private HashMap<Integer, K> characters;
	private int flag;
	private Inventory inventory;
	private int ID = 0;

	public Team() {
		characters = new HashMap<>();
		flag = 0; // Di default, 0 indica il team dei personaggi principali
	}

	public double getRandomValue() {
		return (Math.random() * characters.size());
	}

	public void put(K pc){
		characters.put(ID++, pc);
	}
	/**
	 * Questo metodo restituisce il flag del Team.
	 * 
	 * @return Il flag del Team
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * Questo metodo permette di settare un flag per il Team. Una volta
	 * assegnato, verrà effettuata una notifica a ogni componente del Team, che
	 * aggiornerà la sua variabile di conseguenza.
	 * 
	 * @param flag
	 *            Il flag del Team
	 */
	public void setFlag(int flag) {
		this.flag = flag;
		for (PlayableCharacter pc : characters.values())
			pc.setTeam(this);
	}

	/**
	 * @return the inventario
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * @param inventario
	 *            the inventario to set
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public String toString() {
		return characters.toString();
	}

	public K get(Integer index) {
		return characters.get(index);
	}

	public int size() {
		return characters.size();
	}

	class TeamIterator implements Iterator<K> {
		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentIndex < characters.size();
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			return characters.get(currentIndex++);
		}

		@Override
		public void remove() {
			characters.remove(currentIndex);
			ID--;
		}
	}

	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return new TeamIterator();
	}
}
