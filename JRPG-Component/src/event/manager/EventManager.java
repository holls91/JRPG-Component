package event.manager;

import event.Event;
import event.action.Action;
import event.consequences.Consequence;
import event.preconditions.Precondition;

/**
 * Il GestoreEventi è colui che si occupa dell'esecuzione dell'Azione degli
 * Eventi e del controllo delle Precondizioni e Conseguenze.
 * 
 * @author Simona Francini
 * 
 */
public class EventManager {
	/**
	 * Questo metodo prende in ingresso un personaggi.Character e scorre la sua lista di Eventi: se ne trova uno che non è stato completato,
	 * lo esegue e ferma il ciclo.
	 * @param character Il personaggio di cui vogliamo eseguire l'evento.
	 */
	//Il break serve per evitare di andare troppo avanti con trama o quest.
	public void execute(characters.Character character) {
		for(Event event : character.getEventList()){
			if(!event.isCompleted()){
				if(executePrecondition(event)){
					executeAction(event);
					executeConsequence(event);
					break;
				}
			}
		}
	}
	
	/**
	 * Questo metodo esegue le Precondizioni dell'Evento passato in argomento: se sono tutte soddisfatte, restituisce True;
	 * restituisce False se almeno una non è soddisfatta.
	 * @param event L'Evento di cui si vogliono eseguire le Precondizioni
	 * @return True - Se le Precondizioni sono tutte soddisfatte; False altrimenti
	 */
	protected boolean executePrecondition(Event event){
		if(event.getPrec()!=null)
			for(Precondition prec : event.getPrec())
				if(!prec.execute())
					return false;
		return true;
	}

	/**
	 * Questo metodo riceve in ingresso un Evento e ne esegue l'Azione.
	 * 
	 * @param event l'Evento di cui si vuole eseguire l'Azione.
	 */
	protected void executeAction(Event event) {
		for(Action action : event.getAction())
			action.execute();
	}

	/**
	 * Questo metodo esegue la conseguenza dell'Evento e lo mette come Completato se è un evento che non si può ripetere.
	 * @param event L'evento di cui eseguire la conseguenza.
	 */
	protected void executeConsequence(Event event) {
		if(event.getCons()!=null)
			for(Consequence cons : event.getCons()){
				cons.execute();
				if(event.isOneTimeEvent()){
					event.setCompleted(true);
				}
			}
	}
	
}
