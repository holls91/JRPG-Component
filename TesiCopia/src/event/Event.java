package event;

import java.util.ArrayList;

import event.action.Action;
import event.consequences.Consequence;
import event.preconditions.Precondition;

/**
 * La classe Evento permette di gestire sia gli Eventi di trama che le Quest. � formata da tre parti: una lista di Precondizioni,
 * che devono essere verificate affinch� l'Evento possa essere eseguito; un'Azione, che pu� essere rappresentata da un dialogo, un'animazione
 * e cos� via; e una Conseguenza, che potr� sbloccare o meno altri Eventi.
 * Un Evento, inoltre, potr� essere ripetibile o meno e potr�, eventualmente, definirsi completato.
 * @author Simona Francini
 *
 */

public class Event {

	private int ID;
	private static int ID_STATIC = 0;
	
	private ArrayList<Precondition> prec;
	private ArrayList<Action> action;
	private ArrayList<Consequence> cons;
	
	private boolean oneTimeEvent;
	private boolean completed;
	
	public Event(ArrayList<Precondition> prec, ArrayList<Action> azione, ArrayList<Consequence> cons, boolean oneTimeEvent){
		ID = ID_STATIC++;
		this.prec = prec;
		this.action = azione;
		this.cons = cons;
		this.oneTimeEvent = oneTimeEvent;
		completed = false;
	}

	/**
	 * Restituisce l'ID dell'Evento
	 * @return l'ID dell'Evento
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Setta l'ID corrente a un nuovo valore
	 * @param iD Il nuovo valore di ID
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Restituisce la lista delle Precondizioni dell'Evento
	 * @return La lista delle Precondizioni dell'Evento
	 */
	public ArrayList<Precondition> getPrec() {
		return prec;
	}

	/**
	 * Permette di settare la lista di Precondizioni
	 * @param prec La lista di Precondizioni
	 */
	public void setPrec(ArrayList<Precondition> prec) {
		this.prec = prec;
	}
	
	/**
	 * Restituisce la lista delle Azioni dell'Evento
	 * @return La lista delle Azioni dell'Evento
	 */
	public ArrayList<Action> getAction() {
		return action;
	}
	
	/**
	 * Permette di settare la lista di Azioni
	 * @param prec La lista di Azioni
	 */
	public void setAction(ArrayList<Action> action) {
		this.action = action;
	}
	
	/**
	 * Restituisce la lista delle Conseguenze dell'Evento
	 * @return La lista delle Conseguenze dell'Evento
	 */
	public ArrayList<Consequence> getCons() {
		return cons;
	}
	
	/**
	 * Permette di settare la lista di Conseguenze
	 * @param prec La lista di Conseguenze
	 */
	public void setCons(ArrayList<Consequence> cons) {
		this.cons = cons;
	}
	
	/**
	 * Questo metodo ci dice se l'Evento � ripetibile o meno
	 * @return True - Se l'evento non � ripetibile; False altrimenti
	 */
	public boolean isOneTimeEvent() {
		return oneTimeEvent;
	}

	/**Permette di settare l'Evento come ripetibile o meno
	 * @param oneTimeEvent True - Se l'evento non � ripetibile; False altrimenti
	 */
	public void setOneTimeEvent(boolean oneTimeEvent) {
		this.oneTimeEvent = oneTimeEvent;
	}

	/**
	 * Questo metodo ci dice se l'Evento � completato
	 * @return True - Se l'evento � completato; False altrimenti
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * Permette di settare l'Evento come completato
	 * @param completed Boolean che indica se l'Evento � completato o no
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
