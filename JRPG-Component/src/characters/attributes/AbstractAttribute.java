package characters.attributes;

/**
 * Questa classe rappresenta gli Attributi dei Personaggi, cioè le statistiche indicano le capacità fisiche e magiche del Personaggio.
 * Un Attributo ha un valore di base e un moltiplicatore di base.
 * @author Simona Francini
 *
 */
/*
 * Gli attributi sono strutturati come un Composite, quindi abbiamo questa classe che è la superclasse, che verrà poi estesa
 * da foglie e da un "contenitore" di AbstractAttribute.
 */
public abstract class AbstractAttribute {

	private String name;
	private int baseValue;
	private double baseMolt;
	/*
	 * La variabile type ha un Enum generico, che potrà essere definito dall'utente finale.
	 */
	private Enum<? extends Enum<?>> type;
	
	public AbstractAttribute(String name, int baseValue, double baseMolt, Enum<? extends Enum<?>> type){
		this.name = name;
		this.baseValue = baseValue;
		this.baseMolt = baseMolt;
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public Enum<? extends Enum<?>> getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Enum<? extends Enum<?>> type) {
		this.type = type;
	}

	/**
	 * Restituisce il valore di base dell'Attributo
	 * @return Il valore di base dell'Attributo
	 */
	public int getBaseValue() {
		return baseValue;
	}

	/**
	 * Restituisce il moltiplicatore di base dell'Attributo
	 * @return Il moltiplicatore di base dell'Attributo
	 */
	public double getBaseMolt() {
		return baseMolt;
	}

	/**
	 * Restituisce il nome dell'Attributo
	 * @return Il nome dell'Attributo
	 */
	public String getName() {
		return name;
	}

	/**
	 * Permette di settare un nuovo valore di base per l'Attributo
	 * @param baseValue Un nuovo valore di base per l'Attributo
	 */
	public void setBaseValue(int baseValue) {
		this.baseValue = baseValue;
	}

	/**
	 * Permette di settare un nuovo moltiplicatore di base per l'Attributo
	 * @param baseValue Un nuovo moltiplicatore di base per l'Attributo
	 */
	public void setBaseMolt(double baseMolt) {
		this.baseMolt = baseMolt;
	}
	
	
	
}
