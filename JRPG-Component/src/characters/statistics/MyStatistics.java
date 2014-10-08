package characters.statistics;

import java.util.EnumMap;
import java.util.Iterator;

import characters.attributes.ConcreteAttribute;
import characters.attributes.StatType;


/**
 * Sottoclasse di Statistiche, che prevede un'implementazione concreta tramite EnumMap di <StatType, ConcreteAttribute>.
 * @author Simona Francini
 *
 */ 
public class MyStatistics implements Statistics{

	private EnumMap<StatType, ConcreteAttribute> stat;

	
	public MyStatistics(){
		stat = new EnumMap<>(StatType.class);
	}
	
	public ConcreteAttribute getAttr(Enum<? extends Enum<?>> statType) {
		return this.stat.get(statType);
	}
	
	public void put(ConcreteAttribute attr) {
		stat.put((StatType) attr.getType(), attr);
	}
	
	public String toString() {
		return stat.toString();
	}

	class StatIterator implements Iterator<Enum<?>>{

		private int currentIndex = 0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentIndex < StatType.values().length;
		}

		@Override
		public StatType next() {
			// TODO Auto-generated method stub
			return StatType.values()[currentIndex++];
		}

		@Override
		public void remove() {
			stat.remove(StatType.values()[currentIndex]);
		}
		
	}

	@Override
	public Iterator<Enum<?>> iterator() {
		return new StatIterator();
	}

}
