package characters.inventory;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import characters.item.InventoryItem;
import characters.item.Item;
import characters.menuoptions.MenuOption;

public class MyInventory implements Inventory{

	private LinkedHashMap<Integer, InventoryItem> inventory;

	public MyInventory() {
		inventory = new LinkedHashMap<>();
	}

	public MyInventory(LinkedHashMap<Integer, InventoryItem> inventory) {
		this.inventory = inventory;
	}

	public void addItem(InventoryItem item) {
		inventory.put(item.getItem().getID(), item);
	}

	public void addItem(Item item, int quantity) {
		inventory.get(item.getID()).setQuantity(
				inventory.get(item.getID()).getQuantity() + quantity);
	}

	public void removeItem(Item item, int quantity) {
		inventory.get(item.getID()).setQuantity(
				inventory.get(item.getID()).getQuantity() - quantity);
		if (inventory.get(item.getID()).getQuantity() == 0)
			inventory.remove(item.getID());
	}

	public void removeItem(Item item) {
		removeItem(item, 1);
	}

	public String toString() {
		String out = "";
		for (Entry<Integer, InventoryItem> entry : inventory.entrySet()) {
			out += "\n\t" + entry.getValue().getItem();
		}
		return out;
	}

	@Override
	public String showCategories() {
		return toString();
	}

	@Override
	public String showCategoryElements(int category) {
		return toString();
	}

	@Override
	public void printAskedLevel(int levelAsk, int... infos) {
		System.out.println(showCategories());
	}

	@Override
	public MenuOption getItem(int... info) {
		return inventory.get(info[0]).getItem();
	}

	public int getLevels() {
		// TODO Auto-generated method stub
		return 1;
	}

	class InventoryIterator implements Iterator<InventoryItem>{

		private int currentIndex = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentIndex < inventory.size();
		}

		@Override
		public InventoryItem next() {
			// TODO Auto-generated method stub
			return inventory.get(currentIndex++);
		}

		@Override
		public void remove() {
			inventory.remove(currentIndex);
		}
		
	}
	@Override
	public Iterator<InventoryItem> iterator() {
		// TODO Auto-generated method stub
		return new InventoryIterator();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return inventory.isEmpty();
	}

	@Override
	public Item getRandomItem() {
			int choose = (int)(Math.random() * inventory.size());
			return inventory.get(choose).getItem();
	}

}
