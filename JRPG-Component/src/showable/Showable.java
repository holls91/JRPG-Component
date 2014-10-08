package showable;

import characters.menuoptions.MenuOption;

/*
 * Questa interfaccia l'ho creata per unificare tutte quelle classi che hanno necessit� di essere stampate (Inventario, Moveset e cos� via).
 */
public interface Showable {
	
	public String showCategories();
	public String showCategoryElements(int category);
	public void printAskedLevel(int levelAsk, int... info);
	public MenuOption getItem(int... info);
	public int getLevels();
}
