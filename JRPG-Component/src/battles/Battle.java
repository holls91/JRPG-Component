package battles;


/**
 * La classe Scontro ha il compito di gestire le battaglie all'interno del
 * gioco. Prende in ingresso i due Team che si oppongono e gestisce i turni, lo
 * svolgimento della battaglia, il controllo della vittoria\game over e la
 * distribuzione dei premi a fine scontro.
 * 
 * @author Simona Francini
 * 
 */
public class Battle {

	/*
	 * Questa variabile rappresenta uno Strategy che stabilisce in che modo vengono decisi i turni.
	 */
	private Turn turn;
	/*
	 * Ha uno Strategy che definisce, in modo personalizzato, il comportamento dei
	 * vari metodi di startFight.
	 */
	private BattleBehavior battle;

	public Battle(BattleBehavior battle, Turn turn) {
		this.battle = battle;
		this.turn = turn;
		startFight();
	}

	/**
	 * Questo metodo gestisce lo scontro in ogni sua parte: si estrae il primo
	 * della lista dei turni, si ottiene la mossa che vuole fare attraverso un
	 * metodo, allo stesso modo si ottiene il target su cui fare la mossa e
	 * infine la si esegue; in base all’esito dello scontro, si potrà incappare
	 * nel Game Over o nella vittoria.
	 */
	/*
	 * Segue il pattern Template: infatti l'utente finale avrà il compito di riscrivere solamente
	 * i metodi che sono al suo interno.
	 */
	public void startFight() {
		while (battle.isTeamAlive()) {
			turn.manageTurn();
			battle.setSource(turn.next());
			if (battle.checkPrerequisites()) {
				battle.getMove(battle.getSource());
				battle.setTargets(battle.selectTarget(battle.getSource().getTeam().getFlag()));
				battle.executeMove(battle.getMove(), battle.getSource(), battle.getTargets());
				battle.printMove();
				battle.checkHealthStatus();
			}
			turn.finishTurn();
		}
		battle.checkEndBattle();
	}

}
