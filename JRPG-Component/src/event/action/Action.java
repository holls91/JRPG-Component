package event.action;

/**
 * Questa classe definisce la generica Azione, il cuore dell'evento.
 * @author Simona
 *
 */
public abstract class Action {

	protected int ID;
	protected static int ID_STATIC = 0;
	
	/**
	 * Questo metodo indica ciò che dovrà fare un determinato tipo di Azione. Nella superclasse è astratto,
	 * in modo che possa essere riscritto dalle specifiche sottoclassi.
	 */
	public abstract void execute();
	
	public Action(){
		this.ID = ID_STATIC++;
	}

	/**
	 * Restituisce l'ID dell'Azione
	 * @return L'ID dell'Azione
	 */
	public int getID() {
		return ID;
	}
	
	
}
