package characters;

import java.util.LinkedList;

import event.Event;

/**
 * Questa classe rappresenta tutti i Personaggi, siano essi giocabili e non. Contiene un nome e una lista di eventi.
 * @author Simona Francini
 *
 */
public abstract class Character {
	
	/*
	 * Variabili private che possono essere manipolate con getters e setters
	 */
	private String name;
	private LinkedList<Event> eventList; 
	
	public Character(String name){
		this.name = name;
		this.eventList = new LinkedList<>();
	}

	/**
	 * Restituisce il nome del Character
	 * @return Il nome del Character
	 */
	public String getName() {
		return name;
	}

	/**
	 * Permette di settare il nome del Character
	 * @param name Il nome del Character
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Restituisce la lista di Eventi collegati al Character
	 * @return La lista di Eventi collegati al Character
	 */
	public LinkedList<Event> getEventList() {
		return eventList;
	}

	/**
	 * Permette di settare la lista di Eventi collegati al Character
	 * @param listaEventi La lista di Eventi collegata al Character
	 */
	public void setEventList(LinkedList<Event> eventList) {
		this.eventList = eventList;
	}
	
}
