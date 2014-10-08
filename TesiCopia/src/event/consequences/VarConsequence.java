package event.consequences;

import database.VariableDatabase;

/**
 * Questa classe entra in gioco quando la Conseguenza che si vuole dare all'Evento riguarda il cambiamento di una variabile.
 * @author Simona Francini
 *
 */
public class VarConsequence extends Consequence {
	
	protected int idDatabase;
	protected String variable;
	protected int value;
	
	public VarConsequence(int idDatabase, String variable, int value){
		this.idDatabase = idDatabase;
		this.variable = variable;
		this.value = value;
	}
	
	public VarConsequence(int idDatabase){
		this.idDatabase = idDatabase;
	}
	
	/**
	 * Questo metodo controlla innanzitutto su quale database si vuole operare, tramite lo switch su idDatabase,
	 * dopodiché prende la variabile indicata da variable e ne cambia il valore in base a value.
	 */
	@Override
	public boolean execute() {
		switch(idDatabase){
		case 0: return true;
		case 1:  VariableDatabase.changeVariable(variable, value);  return true;
		default: return false;
		}
	}
	
	/**
	 * Restituisce l'ID del database sul quale si vuole operare
	 * @return L'ID del database sul quale si vuole operare
	 */
	public int getIdDatabase() {
		return idDatabase;
	}

	/**
	 * Restituisce la variabile che si vuole modificare
	 * @return La variabile che si vuole modificare
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * Restituisce il nuovo valore che si vuole assegnare alla variabile
	 * @return Il nuovo valore che si vuole assegnare alla variabile
	 */
	public int getValue() {
		return value;
	}
	
}
