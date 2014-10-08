package strategy.formula;

import java.util.EnumMap;

import characters.PlayableCharacter;
import characters.attributes.StatType;

import utilities.Utilities;

public class MyGrowingFormula implements GrowingFormula {

	private EnumMap<StatType, Integer> maxStat;

	public MyGrowingFormula(){
		maxStat = new EnumMap<>(StatType.class);
		for(StatType type : StatType.values())
			maxStat.put(type, 255);
	}
	
	/**
	 * @param maxStat the maxStat to set
	 */
	public void setMaxStat(Integer... maxStat) {
		StatType[] values = StatType.values();
		for(int i = 0; i<maxStat.length; i++){
			this.maxStat.put(values[i], maxStat[i]);
		}
	}
	
	@Override
	public int calculateLevelFromExp(int exp) {
		return (int) (Utilities.getMax_lev()*Math.sqrt(exp/Utilities.getMax_exp()));
	}

	@Override
	public int calculateExpFromLevel(int level) {
		return (int) (Utilities.getMax_exp()*Math.pow((level/Utilities.getMax_lev()), 2));
	}

	@Override
	public void calculateStatsFromExp(PlayableCharacter pc) {
			for(Enum<?> type : pc.getStatistics()){
				calculateStatFromExp(pc, type);
				pc.getStatistics().getAttr(type).applyBonus();
		}

	}

	@Override
	public void calculateStatFromExp(PlayableCharacter pc,
			Enum<? extends Enum<?>> type) {
		pc.getStatistics().getAttr(type).setBaseValue(statFormula(pc, type));
		
	}

	@Override
	public int statFormula(PlayableCharacter pc, Enum<? extends Enum<?>> type) {
		return (int) (maxStat.get(type)*Math.sqrt(pc.getExperience()/Utilities.getMax_exp()));
	}
	
	public void grow(PlayableCharacter pc){
		int levelTemp = pc.getLevel();
		pc.setLevel(calculateLevelFromExp(pc.getExperience()));
		if(pc.getLevel()>levelTemp)
			calculateStatsFromExp(pc);
	}
}
