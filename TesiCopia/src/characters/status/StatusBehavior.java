package characters.status;

import characters.PlayableCharacter;

/**
 * Questa classe rappresenta lo Strategy generico per gestire il comportamento degli Status. Ha un metodo esegui che
 * può essere riscritto dalle sottoclassi.
 * @author Simona Francini
 *
 */
public interface StatusBehavior {

	public void execute(PlayableCharacter source, Status status, PlayableCharacter... targets);
}
