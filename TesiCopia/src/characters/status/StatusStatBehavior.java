package characters.status;

import characters.PlayableCharacter;

/**
 * Questa classe implementa il comportamento di quegli Status che tolgono una certa percentuale a una statistica.
 * @author Simona Francini
 *
 */
public class StatusStatBehavior implements StatusBehavior {

	@Override
	public void execute(PlayableCharacter source, Status status,
			PlayableCharacter... targets) {
		Enum<? extends Enum<?>> type = status.getStatType();
		double percent = status.getPercent();
		for(PlayableCharacter pc : targets){
			int statValue = pc.getAttribute(type).getCurrentValue();
			pc.getAttribute(type).setCurrentValue((int)(statValue-statValue*percent));
		}
	}

	
}
