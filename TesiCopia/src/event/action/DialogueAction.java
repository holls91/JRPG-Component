package event.action;

import database.StringDatabase;

/**
 * Classe che estende Azione e che si occupa di gestire il dialogo.
 * @author Simona
 *
 */
public class DialogueAction extends Action{
	
	private int IDDialogue;

	public DialogueAction(int IDDialogue){
		super();
		this.IDDialogue = IDDialogue;
	}

	/**
	 * Questo metodo riscrive quello della superclasse e si occupa di stampare il dialogo, definito da
	 * IDDialogo, che verrà cercato in un database di stringhe.
	 */
	@Override
	public void execute() {
		System.out.println(StringDatabase.getStringByID(IDDialogue));
	}

	/*Getters e Setters*/
	/**
	 * Restituisce l'ID del Dialogo che si vuole eseguire
	 * @return L'ID del Dialogo che si vuole eseguire
	 */
	public int getIDDialogo() {
		return IDDialogue;
	}

	/**
	 * Permette di settare un nuovo ID per il dialogo da eseguire
	 * @param iDDialogo Nuovo ID del dialogo da eseguire
	 */
	public void setIDDialogo(int iDDialogo) {
		IDDialogue = iDDialogo;
	}
}

