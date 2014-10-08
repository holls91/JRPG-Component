package characters.moveset;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import characters.abilities.AbilityType;
import characters.abilities.AbstractAbility;
import characters.menuoptions.MenuOption;


/**
 * Questa classe rappresenta un'implementazione concreta del Moveset.
 * 
 * @author Simona Francini
 * 
 */
public class Moveset implements AbstractMoveset {

	/*
	 * Qui ho dovuto definire la Map all'interno della mia classe, in quanto non
	 * era possibile farlo nella superclasse senza incappare in problemi.
	 */
	private EnumMap<AbilityType, TreeMap<Integer, AbstractAbility>> moveset;
	private int levels = 2;

	public Moveset() {
		moveset = new EnumMap<AbilityType, TreeMap<Integer, AbstractAbility>>(
				AbilityType.class);
	}

	public Moveset(
			EnumMap<AbilityType, TreeMap<Integer, AbstractAbility>> moveset) {
		this.moveset = moveset;
	}

	public void addAbility(AbstractAbility ability) {
		if (!moveset.containsKey(ability.getType())) {
			TreeMap<Integer, AbstractAbility> value = new TreeMap<Integer, AbstractAbility>();
			value.put(ability.getID(), ability);
			moveset.put((AbilityType) ability.getType(), value);
		} else
			moveset.get(ability.getType()).put(ability.getID(), ability);
	}

	public void removeAbility(AbstractAbility ability) {
		moveset.get(ability.getType()).remove(ability.getID());
		if (moveset.get(ability.getType()).isEmpty())
			moveset.remove(ability.getType());
	}

	public AbstractAbility getAbility(Enum<? extends Enum<?>> type,
			Integer abilityType) {
		return moveset.get(type).get(abilityType);
	}

	@Override
	public AbstractAbility getRandomAbility() {
		ArrayList<AbilityType> list = new ArrayList<>(moveset.keySet());
		int choose = (int) (Math.random() * list.size());
		Enum<?> ab = list.get(choose);
		TreeMap<Integer, AbstractAbility> tree = moveset.get(ab);
		System.out.println(tree);

		ArrayList<Integer> list2 = new ArrayList<>(tree.keySet());
		Integer abilityIndex = (int) (Math.random() * list2.size());
		Integer abilityType = list2.get(abilityIndex);
		
		return getAbility(ab, abilityType);

	}

	@Override
	public int getLevels() {
		return levels;
	}

	public String toString() {
		String out = "";
		for (AbilityType at : moveset.keySet()) {
			out += "\n\t" + at.name();
			for (Entry<Integer, AbstractAbility> entry : moveset.get(at)
					.entrySet())
				out += "\n\t" + entry.getKey() + ": " + entry.getValue();
		}
		return out;
	}
	
	/*----------- Interfaccia Mostrabile ------------*/
	@Override
	public String showCategories() {
		String out = "";
		for (AbilityType at : moveset.keySet())
			out += "\n\t" + at.ordinal() + ": " + at;
		return out;
	}

	@Override
	public String showCategoryElements(int category) {
		String out = "";
		AbilityType value = AbilityType.values()[category];
		for (Entry<Integer, AbstractAbility> entry : moveset.get(value)
				.entrySet())
			out += "\n\t" + entry.getKey() + ": " + entry.getValue();
		return out;
	}

	public AbilityType getTypeFromInt(int category) {
		return AbilityType.values()[category];
	}

	@Override
	public void printAskedLevel(int levelAsk, int... info) {
		if (levelAsk == 0)
			System.out.println(showCategories());
		else if (levelAsk == 1) {
			System.out.println(showCategoryElements(info[0]));
		}

	}

	@Override
	public MenuOption getItem(int... info) {
		AbilityType type = this.getTypeFromInt(info[0]);
		return moveset.get(type).get(info[1]);
	}


	/*----------- Interfaccia Iterable ------------*/
	
	class MovesetIterator implements Iterator<Enum<?>> {
		private int currentIndex = 0;
		
		@Override
		public boolean hasNext() {
			return currentIndex < AbilityType.values().length;
		}

		@Override
		public Enum<? extends Enum<?>> next() {
			return AbilityType.values()[currentIndex++];
		}

		@Override
		public void remove() {
			moveset.remove(currentIndex);
		}
	}

	@Override
	public Iterator<Enum<?>> iterator() {
		// TODO Auto-generated method stub
		return new MovesetIterator();
	}

}
