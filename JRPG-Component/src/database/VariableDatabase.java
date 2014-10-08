package database;

import java.util.HashMap;

/**
 * Questa classe rappresenta il database delle variabili di gioco.
 * @author Simona Francini
 *
 */
public class VariableDatabase {

	private static HashMap<String, Integer> variableList;
	
	/**
	 * Questo metodo inizializza la Map, inserendovi alcuni valori di prova
	 */
	public static void inizializza(){
		variableList = new HashMap<>();
	}
	
	/**
	 * Questo metodo permette di ottenere il valore di una variabile a partire dal suo nome
	 * @param variable Variabile di cui si vuole conoscere il valore
	 * @return Il valore della variabile cercata
	 */
	public static Integer getValue(String variable){
		return variableList.get(variable);
	}
	
	/**
	 * Questo metodo permette di dare un nuovo valore a una certa variabile.
	 * @param variable La variabile di cui si vuole cambiare il valore
	 * @param newValue Il nuovo valore da assegnare alla variabile
	 */
	public static void changeVariable(String variable, int newValue){
		variableList.put(variable, newValue);
	}
}
