package event.preconditions;

import database.VariableDatabase;

public class VarPrecondition extends Precondition {
	
	protected int idDatabase;
	protected String variable;
	protected int value;

	public VarPrecondition(int idDatabase, String variable, int value){
		this.idDatabase = idDatabase;
		this.variable = variable;
		this.value = value;
	}
	
	public VarPrecondition(int idDatabase){
		this.idDatabase = idDatabase;
	}
	
	/**
	 * Questo metodo controlla innanzitutto su quale database si vuole operare, tramite lo switch su idDatabase,
	 * dopodiché prende la variabile indicata da variable e ne confronta il valore rispetto a value.
	 */
	@Override
	public boolean execute() {
		switch(idDatabase){
		case 0: return true;
		case 1:  return VariableDatabase.getValue(variable)==value; 
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
	 * Restituisce il valore con cui effettuare il confronto di variabile
	 * @return Il valore con cui effettuare il confronto di variabile
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Permette di settare un nuovo valore con cui effettuare il confronto di variabile
	 * @param newValue Nuovo valore con cui effettuare il confronto di variabile
	 */
	public void setValue(int newValue) {
		value = newValue;
	}
	
}
