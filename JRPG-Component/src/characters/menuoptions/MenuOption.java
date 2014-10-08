package characters.menuoptions;

import characters.PlayableCharacter;

/*
 * Questa classe definisce le opzioni che � possibile trovare in un men�.
 */
public abstract class MenuOption {

	private String name;

	/*
	 * Questo metodo potr� essere riscritto manualmente oppure tramite l'utilizzo di uno Strategy.
	 */
	public abstract void execute(PlayableCharacter source, PlayableCharacter... targets);

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
