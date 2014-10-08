package database;

import java.util.HashMap;
/**
 * Questa classe è un'implementazione primitiva di un database di Stringhe. Questo database ci servirà 
 * per poter cercare i dialoghi utilizzati dal DialogoAzione.
 * @author Simona Francini
 *
 */
public class StringDatabase {

	/**
	 * Questa HashMap conterrà tutti i dialoghi, ordinati per ID.
	 */
	private static HashMap<Integer, String> stringhe;

	/**
	 * Questo metodo inizializza l'HashMap e vi inserisce i dialoghi.
	 */
	public static void inizializza(){
		stringhe = new HashMap<>();
		stringhe.put(0, "Prima stringa");
		stringhe.put(1, "Seconda stringa");
	}
	
	public static String getStringByID(int ID){
		return stringhe.get(ID);
	}
		

}
