package battles;

import java.util.Scanner;

import characters.Enemy;
import characters.Hero;
import characters.PlayableCharacter;
import characters.Team;
import characters.attributes.StatType;
import characters.menuoptions.MenuOption;

import commands.Command;


/**
 * Implementazione concreta del comportamento all'interno dello Scontro.
 * 
 * @author Simona Francini
 * 
 */
public class ConcreteBattleBehavior extends BattleBehavior {

	private int contAllies, contEnemies;

	public ConcreteBattleBehavior(Team<Hero> heroes, Team<Enemy> enemies) {
		super(heroes, enemies);
		contAllies = heroes.size();
		contEnemies = enemies.size();
	}

	protected boolean isTeamAlive() {
		return (contEnemies > 0 && contAllies > 0);
	}

	@Override
	protected boolean checkPrerequisites() {
		return true;
	}

	@Override
	protected void getMove(PlayableCharacter pc) {
		int i = pc.getTeam().getFlag();
		Command cmd;
		do {
			if (i == 0) { // and not Berserk or not Confuso
				int type;
				do {
					System.out.println("\n" + pc.getName()
							+ "\tInserisci mossa!\n " + pc.printCommands());
					Scanner sc = new Scanner(System.in);
					type = sc.nextInt();
				} while (type < 0 || type >= pc.getCommandList().size());
				cmd = pc.getCommandList().get(type);
			} else
				// or Confuso
				cmd = pc.getCommandList().get(
						(int) (Math.random() * pc.getCommandList().size()));
		} while (!cmd.execute());
		setMove(cmd.getMove());
	}

	@Override
	protected PlayableCharacter selectTarget(int i) {
		if (i == 0) {
			System.out.println("Scegli il team: 0 = Alleati; 1 = Nemici");
			Scanner sc = new Scanner(System.in);
			int team = sc.nextInt();
			if (team == 0) {
				System.out.println("Team Alleati: " + getHeroes());
				int name = sc.nextInt();
				return getHeroes().get(name);
			} else {
				System.out.println("Team nemico: " + getEnemies());
				int name = sc.nextInt();
				return getEnemies().get(name);
			}

		} else {
			PlayableCharacter temp = null;
			do {
				temp = getHeroes().get(
						(int) (getHeroes().getRandomValue()));
			} while (temp.getAttribute(StatType.HP).getCurrentValue() == 0);
			return temp;
		}
	}

	@Override
	protected void executeMove(MenuOption option, PlayableCharacter source,
			PlayableCharacter... targets) {
		option.execute(source, targets);

	}

	@Override
	protected void applyConsequences(PlayableCharacter pc) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void checkHealthStatus() {
		if (getSource().getAttribute(StatType.HP).getCurrentValue() <= 0) {
			if (getSource().getTeam().getFlag() == 0)
				contAllies--; // contA - (1-flag)
			else
				contEnemies--; // contN - (flag)
		}
		// for each target
		if (getTargets().getAttribute(StatType.HP).getCurrentValue() <= 0) {
			if (getTargets().getTeam().getFlag() == 0)
				contAllies--; // contA - (flag)
			else
				contEnemies--; // contN - (1-flag)
		}
	}

	@Override
	protected void gameOver() {
		System.out.println("GameOver - La tua squadra è stata annientata!");
	}

	@Override
	protected void victory() {
		System.out.println("Hai vinto! - Hai annientato il nemico!");
		for (Hero pc : getHeroes())
			pc.addExperience(calculateExperience());
		// Assegna Bottino, Esperienza, AP ecc...
	}

	/**
	 * Questo metodo calcola l'esperienza da distribuire agli Eroi in caso di
	 * vittoria.
	 * 
	 * @return L'esperienza guadagnata da ciascun Eroe.
	 */
	protected int calculateExperience() {
		int exp = 0;
		for (Enemy avv : getEnemies())
			exp += avv.getGivenExperience();
		return exp;
	}

	@Override
	protected void checkEndBattle() {
		if (contAllies == 0)
			gameOver();
		if (contEnemies == 0)
			victory();
	}

}
