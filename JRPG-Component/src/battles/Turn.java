package battles;

import characters.Enemy;
import characters.Hero;
import characters.PlayableCharacter;
import characters.Team;

/**
 * Questa classe definisce come vengono gestiti i turni all'interno dello
 * scontro. Contiene una lista di Personaggi che verranno ordinati in base a
 * certi parametri; il primo della lista sarà il primo a poter selezionare la
 * Mossa.
 * 
 * @author Simona Francini
 * 
 */
public abstract class Turn {

	protected Team<Hero> heroes;
	protected Team<Enemy> enemies;

	PlayableCharacter source;

	public Turn(Team<Hero> heroes, Team<Enemy> enemies) {
		this.setHeroes(heroes);
		this.setEnemies(enemies);
		initialize();
	}

	public abstract void manageTurn();

	/**
	 * Questo metodo inizializza la lista dei turni, ordinando i Personaggi in
	 * base a un criterio scelto dall'utente finale.
	 */
	protected abstract void initialize();

	/**
	 * Questo metodo restituisce il prossimo Personaggio che potrà scegliere la
	 * sua Mossa.
	 * 
	 * @return Il prossimo Personaggio che potrà scegliere la sua Mossa
	 */
	public abstract PlayableCharacter next();

	/**
	 * Questo metodo ci comunica che un Personaggio ha eseguito il suo turno e
	 * che quindi avrà una priorità più bassa rispetto agli altri partecipanti.
	 */
	protected abstract void nextTurn();

	/**
	 * Questo metodo comunica cosa fare quando il personaggio ha finito il suo
	 * turno.
	 */
	public abstract void finishTurn();

	/**
	 * Questo metodo permette di inserire nuovamente un Personaggio nella lista
	 * dei turni, una volta eseguita la sua Mossa.
	 * 
	 * @param pers
	 */
	protected abstract void reput(PlayableCharacter pers);

	public void setHeroes(Team<Hero> heroes) {
		this.heroes = heroes;
	}

	public void setEnemies(Team<Enemy> enemies) {
		this.enemies = enemies;
	}

}
