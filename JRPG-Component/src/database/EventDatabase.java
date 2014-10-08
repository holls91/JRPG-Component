package database;

import java.util.HashMap;

/**
 * Questa classe rappresenta il database degli eventi di gioco.
 * @author Simona Francini
 *
 */
import event.Event;

public class EventDatabase {

	private static HashMap<Integer, Event> activeEvent;
	private static HashMap<Integer, Event> nonActiveEvent;
	
	/**
	 * Questo metodo inizializza le due Map, una degli eventi attivi e una degli eventi non attivi.
	 */
	public static void inizializza(){
		activeEvent = new HashMap<>();
		nonActiveEvent = new HashMap<>();
	}
	
	/**
	 * Questo metodo permette di inserire un nuovo evento attivo nella lista.
	 * @param ev L'evento attivo che si vuole inserire
	 */
	public static void putActiveEvent(Event ev){
		activeEvent.put(ev.getID(), ev);
	}
	
	/**
	 * Questo metodo permette di ottenere un evento attivo conoscendone l'ID
	 * @param id L'ID dell'evento attivo che si vuole ottenere
	 * @return L'evento attivo cercato
	 */
	public Event getActiveEventByID(int id){
		return activeEvent.get(id);
	}
	
	/**
	 * Questo metodo permette di inserire un nuovo evento non attivo nella lista.
	 * @param ev L'evento non attivo che si vuole inserire
	 */
	public static void putNonActiveEvent(Event ev){
		nonActiveEvent.put(ev.getID(), ev);
	}
	
	/**
	 * Questo metodo permette di ottenere un evento non attivo conoscendone l'ID
	 * @param id L'ID dell'evento non attivo che si vuole ottenere
	 * @return L'evento non attivo cercato
	 */
	public Event getNonActiveEventByID(int id){
		return nonActiveEvent.get(id);
	}

	/**
	 * Questo metodo restituisce la lista degli eventi attivi
	 * @return La lista degli eventi attivi
	 */
	public static HashMap<Integer, Event> getActiveEvent() {
		return activeEvent;
	}

	/**
	 * Questo metodo restituisce la lista degli eventi non attivi
	 * @return La lista degli eventi non attivi
	 */
	public static HashMap<Integer, Event> getNonActiveEvent() {
		return nonActiveEvent;
	}
	
	public static String stampa(){
		return "Eventi attivi: "+activeEvent+"\nEventi non attivi: "+nonActiveEvent;
	}
}
