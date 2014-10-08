package characters.abilities;

import characters.PlayableCharacter;
import strategy.attack.AbstractAttackFormula;
import strategy.attack.AttackAbilityFormula;

/**
 * Questa classe rappresenta quel genere di Abilità che infligge danno.
 * @author Simona Francini
 *
 */
public class DamageAbility extends AbstractAbility {

	private int damage;
	private double critic;
	/*
	 * Visto che le formule di danno possono essere personalizzate, ho pensato di usare uno Strategy. Ogni abilità
	 * avrà quindi il suo Strategy che definirà la struttura della formula di danno.
	 */
	private AbstractAttackFormula strategy;

	public DamageAbility(int damage, double critic, double probability, boolean sureHit, Enum<? extends Enum<?>> type){
		super(type);
		this.damage = damage;
		this.critic = critic;
		setProbability(probability);
		setSureHit(sureHit);
//		script.runScriptFunction("create", this);
		
	}
	
	public DamageAbility(Enum<? extends Enum<?>> type){
		this(10, 0.05, 0.95, false, type);
		strategy = new AttackAbilityFormula();
	}

	@Override
	public void execute(PlayableCharacter source, PlayableCharacter... targets) {
		strategy.execute(source, this, targets);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getCritic() {
		return critic;
	}

	public void setCritic(double critic) {
		this.critic = critic;
	}
	
	/**
	 * @return the strategy
	 */
	public AbstractAttackFormula getStrategy() {
		return strategy;
	}

	/**
	 * @param strategy the strategy to set
	 */
	public void setStrategy(AbstractAttackFormula strategy) {
		this.strategy = strategy;
	}

}
