package characters.equiplist;

import java.util.EnumMap;
import java.util.Iterator;

import characters.PlayableCharacter;
import characters.attributes.Bonus;
import characters.equip.Equip;
import characters.equip.EquipType;
import characters.menuoptions.MenuOption;


/**
 * Sottoclasse di ListaEquip che utilizza una map di <EquipType, Equip> per
 * gestire l'Equip del personaggio.
 * 
 * @author Simona Francini
 * 
 */
public class MyEquipList implements EquipList {

	private EnumMap<EquipType, Equip> equip;

	public MyEquipList() {
		equip = new EnumMap<>(EquipType.class);
	}
	
	public MyEquipList(EnumMap<EquipType, Equip> equip){
		this.equip = equip;
	}

	@Override
	public void confirmEquip(PlayableCharacter pc, Equip equip) {
		if (getEquip(equip.getType()) != null)
			removeEquip(pc, this.equip.get(equip.getType()));
		this.equip.put((EquipType) equip.getType(), equip);
		for (Bonus b : equip.getBonusList()) {
			b.addBonusToAttribute(pc);
			pc.getAttribute(b.getType()).applyBonus();
		}
	}

	@Override
	public void removeEquip(PlayableCharacter pc, Equip equip) {
		this.equip.remove(equip.getType());
		for (Bonus b : equip.getBonusList()) {
			b.removeBonusToAttribute(pc);
			pc.getAttribute(b.getType()).applyBonus();
		}
	}

	@Override
	public Equip getEquip(Enum<?> equip) {
		return this.equip.get(equip);
	}

	/*----------------- Interfaccia Mostrabile ------------------*/
	@Override
	public String showCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showCategoryElements(int category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printAskedLevel(int levelAsk, int... info) {
		// TODO Auto-generated method stub

	}

	@Override
	public MenuOption getItem(int... info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLevels() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*----------------- Interfaccia Iterator ------------------*/

	class EquipIterator implements Iterator<Enum<?>> {
		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			return currentIndex < EquipType.values().length;
		}

		@Override
		public Enum<? extends Enum<?>> next() {
			return EquipType.values()[currentIndex++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}
	}

	@Override
	public Iterator<Enum<?>> iterator() {
		// TODO Auto-generated method stub
		return new EquipIterator();
	}

}
