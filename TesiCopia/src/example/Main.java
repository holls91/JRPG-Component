package example;

import battles.Battle;
import battles.ConcreteBattleBehavior;
import battles.ConcreteTurn;
import characters.Enemy;
import characters.Hero;
import characters.Team;
import characters.abilities.AbilityType;
import characters.abilities.DamageAbility;
import characters.attributes.BaseBonus;
import characters.attributes.ConcreteAttribute;
import characters.attributes.StatType;
import characters.equip.Equip;
import characters.equip.EquipType;
import characters.inventory.Inventory;
import characters.inventory.MyInventory;
import characters.item.InventoryItem;
import characters.item.Item;
import characters.moveset.Moveset;
import strategy.attack.AttackAbilityFormula;
import strategy.item.AttributeItemStrategy;

import commands.AbilityCommand;
import commands.ItemCommand;
import commands.MovesetCommand;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println("--------- Inizio esempio ---------\n\nCreazione di tre Personaggi, due Eroi e un Avversario.");
		Hero pers = new Hero("Eroe 1");
		Enemy pers2 = new Enemy("Avversario 1");
		Hero pers3 = new Hero("Eroe 2");

		System.out.println("Creati -> " + pers + ", " + pers2 + ", " + pers3);

		System.out
				.println("\n-------- Creazione e assegnazione statistiche --------\n");
		ConcreteAttribute atk = new ConcreteAttribute("Attacco", 10, 0, StatType.Attacco_Fisico);
		ConcreteAttribute atk2 = new ConcreteAttribute("Attacco", 12, 0, StatType.Attacco_Fisico);
		ConcreteAttribute atk3 = new ConcreteAttribute("Attacco", 11, 0, StatType.Attacco_Fisico);
		
		ConcreteAttribute def = new ConcreteAttribute("Difesa", 6, 0, StatType.Difesa_Fisica);
		ConcreteAttribute def2 = new ConcreteAttribute("Difesa", 5, 0, StatType.Difesa_Fisica);
		ConcreteAttribute def3 = new ConcreteAttribute("Difesa", 7, 0, StatType.Difesa_Fisica);
		
		ConcreteAttribute vel = new ConcreteAttribute("Velocita", 5, 0, StatType.Velocita);
		ConcreteAttribute vel2 = new ConcreteAttribute("Velocita", 6, 0, StatType.Velocita);
		ConcreteAttribute vel3 = new ConcreteAttribute("Velocita", 7, 0, StatType.Velocita);

		ConcreteAttribute hp = new ConcreteAttribute("HP", 11, 0, StatType.HP);
		ConcreteAttribute hp2 = new ConcreteAttribute("HP", 12, 0, StatType.HP);
		ConcreteAttribute hp3 = new ConcreteAttribute("HP", 12, 0, StatType.HP);

		pers.getStatistics().put(atk);
		pers.getStatistics().put(def);
		pers.getStatistics().put(vel);
		pers.getStatistics().put(hp);

		pers2.getStatistics().put(atk2);
		pers2.getStatistics().put(def2);
		pers2.getStatistics().put(vel2);
		pers2.getStatistics().put(hp2);

		pers3.getStatistics().put(atk3);
		pers3.getStatistics().put(def3);
		pers3.getStatistics().put(vel3);
		pers3.getStatistics().put(hp3);

		System.out.println("Stampa delle statistiche: \n" + pers.getName()
				+ ": " + pers.getStatistics() + "\n" + pers2.getName() + ": "
				+ pers2.getStatistics() + "\n" + pers3.getName() + ": "
				+ pers3.getStatistics());

		Team<Hero> uno = new Team<>();
		uno.put(pers);
		uno.put(pers3);
		uno.setFlag(0);

		Inventory inv = new MyInventory();
		pers.getTeam().setInventory(inv);

		Team<Enemy> due = new Team<Enemy>();
		due.put(pers2);
		due.setFlag(1);
		
		
		System.out
				.println("\n-------- Creazione e assegnazione degli Equip --------\n");
		Equip scarpette = new Equip("Scarpette", EquipType.PIEDI);
		scarpette.add(new BaseBonus("Bonus vel", 10, 0, StatType.Velocita));
		pers.confirmEquip(scarpette);

		System.out.println("Equip creato: " + scarpette + ",\n\tassegnato a "
				+ pers.getName());
		System.out.println("Statistiche di " + pers.getName()
				+ " dopo l'assegnazione dell'Equip " + scarpette.getName()
				+ ": " + pers.getStatistics().toString());

		System.out
				.println("\n-------- Assegnazione di un Equip dello stesso tipo --------\n");
		Equip scarponi = new Equip("Scarponi", EquipType.PIEDI);
		scarponi.add(new BaseBonus("Bonus dif", 5, 0, StatType.Difesa_Fisica));
		scarponi.add(new BaseBonus("Bonus vel", 8, 0, StatType.Velocita));
		pers.confirmEquip(scarponi);
		System.out.println("Equip creato: " + scarponi + ",\n\tassegnato a "
				+ pers.getName());
		System.out.println("Statistiche di " + pers.getName()
				+ " dopo l'assegnazione dell'Equip " + scarponi.getName()
				+ ": " + pers.getStatistics().toString());

		System.out.println("\n-------- Creazione di un oggetto --------\n");
		Item ati = new Item("Calcio", "Dona più attacco", 2, StatType.Attacco_Fisico);
		ati.setStrategy(new AttributeItemStrategy(ati));

		System.out.println("Oggetto creato -> " + ati);

		pers.getTeam().getInventory().addItem(new InventoryItem(ati, 1));
		ati.execute(pers, pers);
		
		System.out.println("Statistiche di " + pers.getName()
				+ " dopo l'uso dell'oggetto " + ati.getName() + ": "
				+ pers.getStatistics());

/*		System.out
				.println("\n-------- Creazione e utilizzo di un oggetto di cura --------\n");
		pers.getAttribute(StatType.HP).setCurrentValue(80);
		System.out.println("HP correnti di " + pers.getName() + " settati a "
				+ pers.getAttribute(StatType.HP).getCurrentValue() + "/"
				+ pers.getAttribute(StatType.HP).getValue());*/


		
//		Prova per lo scontro: togliere il commento per eseguirlo.		


		Item pot = new Item("Pozione", "Dona 20 HP", 20, StatType.HP);
		pot.setStrategy(new AttributeItemStrategy(pot));
		inv.addItem(new InventoryItem(pot, 1));
		
		Moveset moveset = new Moveset();
		DamageAbility ability = new DamageAbility(AbilityType.OFFENSIVA);
		ability.setStrategy(new AttackAbilityFormula());
		ability.setName("Vento vorticoso");
		moveset.addAbility(ability);
		pers.setMoveset(moveset);

		DamageAbility ability2 = new DamageAbility(AbilityType.OFFENSIVA);
		ability2.setStrategy(new AttackAbilityFormula());
		ability2.setName("Attacco");
		
		pers.getCommandList().add(new AbilityCommand(pers, ability2));
		pers.getCommandList().add(new ItemCommand(pers));
		pers.getCommandList().add(new MovesetCommand(pers));
		pers2.getCommandList().add(new AbilityCommand(pers, ability2));
		pers3.getCommandList().add(new AbilityCommand(pers, ability2));
		
		
		System.out.println("Oggeto creato -> " + pot);
/*		pot.esegui(pers, pers);
		System.out.println("HP di " + pers.getName()
				+ " dopo l'utilizzo dell'oggetto " + pot.getName() + ": "
				+ pers.getAttribute(StatType.HP).getCurrentValue() + "/"
				+ pers.getAttribute(StatType.HP).getValue());*/
		
		Battle scontro = new Battle(new ConcreteBattleBehavior(uno, due), new ConcreteTurn(uno, due));
	}

}
