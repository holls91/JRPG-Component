package battles;

import characters.Enemy;
import characters.Hero;
import characters.PlayableCharacter;
import characters.Team;
import characters.attributes.StatType;
import characters.menuoptions.MenuOption;

/**
 * Questa classe definisce un generico svolgimento della battaglia. Segue il pattern Strategy, quindi è da associare
 * alla classe Scontro.
 * @author Simona Francini
 *
 */
public abstract class BattleBehavior {
	
	private Team<Hero> heroes;
	private Team<Enemy> enemies;
	private PlayableCharacter source;
	private PlayableCharacter targets;
	private MenuOption move;

	public BattleBehavior(Team<Hero> heroes, Team<Enemy> enemies){
		this.heroes = heroes;
		this.enemies = enemies;
	}
	
	/*
	 * Lista di metodi, che fanno parte dello scontro, che l'utente finale deve reimplementare.
	 */
	protected abstract boolean isTeamAlive();
	protected abstract boolean checkPrerequisites();
	protected abstract void getMove(PlayableCharacter pc);
	protected abstract PlayableCharacter selectTarget(int i);
	protected abstract void executeMove(MenuOption option, PlayableCharacter source, PlayableCharacter... targets);
	protected abstract void applyConsequences(PlayableCharacter pc);
	protected abstract void checkHealthStatus();
	protected abstract void checkEndBattle();
	protected abstract void gameOver();
	protected abstract void victory();

	/**
	 * @return the personaggi
	 */
	public Team<Hero> getHeroes() {
		return heroes;
	}

	/**
	 * @param personaggi the personaggi to set
	 */
	public void setHeroes(Team<Hero> personaggi) {
		this.heroes = personaggi;
	}

	/**
	 * @return the nemici
	 */
	public Team<Enemy> getEnemies() {
		return enemies;
	}

	/**
	 * @param nemici the nemici to set
	 */
	public void setEnemies(Team<Enemy> enemies) {
		this.enemies = enemies;
	}
	
	/**
	 * @return the source
	 */
	public PlayableCharacter getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(PlayableCharacter source) {
		this.source = source;
	}

	/**
	 * @return the targets
	 */
	public PlayableCharacter getTargets() {
		return targets;
	}

	/**
	 * @param targets the targets to set
	 */
	public void setTargets(PlayableCharacter targets) {
		this.targets = targets;
	}

	/**
	 * @return the move
	 */
	public MenuOption getMove() {
		return move;
	}

	/**
	 * @param move the move to set
	 */
	public void setMove(MenuOption move) {
		this.move = move;
	}

	public void printMove(){
		System.out.println("Azione\t" + getSource().getName() + "\t"
				+ getSource().getAttribute(StatType.HP).getCurrentValue() + "/"
				+ getSource().getAttribute(StatType.HP).getValue() + " HP\t"
				+ "con\t" + getMove() + "\t" + "su\t" + getTargets().getName()
				+ "\t"
				+ getTargets().getAttribute(StatType.HP).getCurrentValue() + "/"
				+ getTargets().getAttribute(StatType.HP).getValue() + " HP");
	}
}
