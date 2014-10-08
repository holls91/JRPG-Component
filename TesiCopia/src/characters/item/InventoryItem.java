package characters.item;

/*
 * Ho creato questa classe "ponte" tra l'Inventario e l'Item, questo perché volevo che l'oggetto stesso fosse slegato dalla sua
 * rappresentazione nell'Inventario. Infatti questa classe si limita ad associare una quantità a ogni Item.
 */
public class InventoryItem {

	private Item item;
	private int quantity;
	
	public InventoryItem(Item item, int quantity){
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
