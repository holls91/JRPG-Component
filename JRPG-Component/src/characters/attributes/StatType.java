package characters.attributes;

/**
 * Questo Enum definisce gli Attributi principali del Personaggio. Serve per indicare a quale Attributo è riferito un Equip, un Item o un Bonus.
 * @author Simona Francini
 *
 */
public enum StatType {

	HP(), MP(),
	Attacco_Fisico("Attacco"), Difesa_Fisica("Difesa"),
	Attacco_Magico("ATT Magico"), Difesa_Magica("DIF Magica"),
	Potenza("Potenza"), Potenza_Magica("POT Magica"),
	Destrezza(), Destrezza_Magica("DES Magica"),	// Evasione, Evasione_Magica
	Velocita("Velocità"), Vitalita("Vitalità"), Vigore(), Fortuna(), Istinto();
	
	private String description;
	
	private StatType(){
		setName(this.name());
	}
	private StatType(String descr){
		setName(descr);
	}

	public String getName() {
		return description;
	}
	public void setName(String name) {
		this.description = name;
	}
		
	public String toString(){
		return description;
	}
	
}
