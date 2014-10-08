package event.consequences;

public abstract class Consequence {

	protected int ID;
	protected static int ID_STATIC = 0;

	/**
	 * Questo metodo indica ciò che dovrà fare un determinato tipo di Conseguenza. Nella superclasse è astratto,
	 * in modo che possa essere riscritto dalle specifiche sottoclassi.
	 * @return 
	 */
	public abstract boolean execute();
	
	public Consequence(){
		this.ID = ID_STATIC++;
	}
	
	/**
	 * Restituisce l'ID della Conseguenza
	 * @return L'ID della Conseguenza
	 */
	public int getID() {
		return ID;
	}

}
