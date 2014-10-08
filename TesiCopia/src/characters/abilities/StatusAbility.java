package characters.abilities;

import java.util.ArrayList;

import characters.PlayableCharacter;
import characters.status.Status;


/**
 * Questa classe rappresenta quel genere di Abilità che infligge Status alterati.
 * @author Simona Francini
 *
 */
public class StatusAbility extends AbstractAbility {
	
	private ArrayList<Status> statusSource, statusTarget;
	
	public StatusAbility(ArrayList<Status> statusSource, ArrayList<Status> statusTarget, Enum<? extends Enum<?>> type){
		super(type);
		this.statusSource = statusSource;
		this.statusTarget = statusTarget;
//		script.runScriptFunction("create", this);
	}
	
	public StatusAbility(Enum<? extends Enum<?>> type){
		super(type);
		this.statusSource = new ArrayList<>();
		this.statusTarget = new ArrayList<>();
//		script.runScriptFunction("create", this);
	}
	
	/*
	 * Questo metodo ha un comportamento standard, per cui l'ho definito io.
	 * @see personaggi.abilità.AbstractAbility#esegui(personaggi.PlayableCharacter, personaggi.PlayableCharacter[])
	 */
	@Override
	public void execute(PlayableCharacter source, PlayableCharacter... targets) {
		for(Status status : statusSource)
			source.getStatusList().add(status);
		for(Status status : statusTarget)
			for(PlayableCharacter target : targets)
				target.getStatusList().add(status);
	}

	public ArrayList<Status> getStatusSource() {
		return statusSource;
	}

	public void setStatusSource(ArrayList<Status> statusSource) {
		this.statusSource = statusSource;
	}

	public ArrayList<Status> getStatusTarget() {
		return statusTarget;
	}

	public void setStatusTarget(ArrayList<Status> statusTarget) {
		this.statusTarget = statusTarget;
	}

	
}
