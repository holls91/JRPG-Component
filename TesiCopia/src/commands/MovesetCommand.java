package commands;

import java.util.Scanner;

import characters.PlayableCharacter;
import characters.menuoptions.MenuOption;
import characters.moveset.AbstractMoveset;


/**
 * Questa classe rappresenta il comando del menù che permette di accedere alle abilità.
 * @author Simona Francini
 *
 */
/*
 * Sottoclasse di Command. Gestisce la voce di comando "Abilità".
 */
public class MovesetCommand extends Command {

	private AbstractMoveset moveset;
	private int askedLevel;

	public MovesetCommand(PlayableCharacter pc) {
		super(pc);
		this.moveset = pc.getMoveset();
	}

	/*
	 * Questo metodo è stato riscritto in modo tale da poter esplorare i sottomenù, se esistono, pur non sapendo
	 * a priori quanti sono. Alla fine, l'oggetto richiesto verrà assegnato alla variabile option.
	 * @see comandi.Command#playerChoose()
	 */
	public boolean playerChoose(){
		askedLevel = 0;
		do{
			moveset.printAskedLevel(askedLevel, level);
			Scanner scanner = new Scanner(System.in);
			int choose = scanner.nextInt();
			this.level[askedLevel] = choose;
			if(choose==-1)
				askedLevel--;
			else
				askedLevel++;
		} while(askedLevel!=-1 && askedLevel!=moveset.getLevels());
		if(askedLevel==-1)
			return false;
		option = moveset.getItem(level);
		return true;
	}
	
	public boolean cpuChoose(){
		option = moveset.getRandomAbility();
		return true;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Ability";
	}

	@Override
	public MenuOption getMove() {
		// TODO Auto-generated method stub
		return option;
	}

	/**
	 * @return the moveset
	 */
	public AbstractMoveset getMoveset() {
		return moveset;
	}

	/**
	 * @param moveset the moveset to set
	 */
	public void setMoveset(AbstractMoveset moveset) {
		this.moveset = moveset;
	}

	/**
	 * @return the askedLevel
	 */
	public int getAskedLevel() {
		return askedLevel;
	}

}
