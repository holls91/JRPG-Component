package event.preconditions;

public abstract class Precondition {
	
	protected int ID;
	protected static int ID_STATIC = 0;
	
	/**
	 * Questo metodo indica ciò che dovrà fare un determinato tipo di Precondizione. Nella superclasse è astratto,
	 * in modo che possa essere riscritto dalle specifiche sottoclassi.
	 */
	public abstract boolean execute();
	
	public Precondition(){
		this.ID = ID_STATIC++;
	}
	
	/**
	 * Restituisce l'ID della Precondizione
	 * @return L'ID della Precondizione
	 */
	public int getID() {
		return ID;
	}

	
}
