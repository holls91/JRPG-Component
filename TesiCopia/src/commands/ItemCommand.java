package commands;

import java.util.Scanner;

import characters.PlayableCharacter;
import characters.inventory.Inventory;
import characters.menuoptions.MenuOption;


/*
 * Sottoclasse di Command. Gestisce la voce di comando "Inventario".
 */
public class ItemCommand extends Command {

	private Inventory inv;

	public ItemCommand(PlayableCharacter pc){
		super(pc);
		this.inv = pc.getTeam().getInventory();

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Item";
	}

	/**
	 * @return the inv
	 */
	public Inventory getInv() {
		return inv;
	}
	
	@Override
	public MenuOption getMove() {
		// TODO Auto-generated method stub
		return option;
	}
	
	/**
	 * @param inv the inv to set
	 */
	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	/*
	 * Questo metodo è stato riscritto in modo tale da poter esplorare i sottomenù, se esistono, pur non sapendo
	 * a priori quanti sono. Alla fine, l'oggetto richiesto verrà assegnato alla variabile option.
	 * @see comandi.Command#playerChoose()
	 */
	@Override
	public boolean playerChoose() {
		if(inv.isEmpty()){
			System.out.println("Inventario vuoto!");
			return false;
		} else{
		int askedLevel = 0;
		do{
			inv.printAskedLevel(askedLevel, level);
			Scanner scanner = new Scanner(System.in);
			int choose = scanner.nextInt();
			this.level[askedLevel] = choose;
			if(choose==-1)
				askedLevel--;
			else
				askedLevel++;
		} while(askedLevel!=-1 && askedLevel!=inv.getLevels());
		if(askedLevel==-1)
			return false;
		option = inv.getItem(level);
		return true;
		}
	}

	@Override
	public boolean cpuChoose() {
		if(inv.isEmpty())
			return false;
		else {
			option = inv.getRandomItem();
			return true;
		}
	}
		


}
