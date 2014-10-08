package characters.inventory;


import java.util.Iterator;

import showable.Showable;

import characters.item.InventoryItem;
import characters.item.Item;
import characters.menuoptions.MenuOption;


/*
 * Visto che, generalmente, Inventario è una voce di menù, l'ho messo come Mostrabile.
 */
public interface Inventory extends Showable, Iterable<InventoryItem> {

	/*
	 * A differenza della ListaEquip, qui ho preferito non usare uno Strategy,
	 * per il semplice fatto che il funzionamento dell'inventario è abbastanza
	 * standard: c'è una lista di oggetti, ognuno con la sua quantità, che può
	 * essere manipolata tramite l'inserimento o rimozione di elementi al suo
	 * interno.
	 */

	public void addItem(InventoryItem item);

	public void addItem(Item item, int quantity);

	public void removeItem(Item item, int quantity);

	public void removeItem(Item item);
	
	public boolean isEmpty();
	
	public Item getRandomItem();

	public String toString();

	@Override
	public String showCategories();

	@Override
	public String showCategoryElements(int category);

	@Override
	public void printAskedLevel(int levelAsk, int... infos);

	@Override
	public MenuOption getItem(int... info);

	public int getLevels();

	@Override
	public Iterator<InventoryItem> iterator();

}
