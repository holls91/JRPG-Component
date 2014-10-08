package utilities;

/**
 * Generica classe di Utilities dove è possibile inserire una serie di valori globali.
 * @author Simona Francini
 *
 */
public class Utilities {

	private static int max_exp = 1000000;
	private static int max_lev = 99;
	
	public static int getMax_exp() {
		return max_exp;
	}

	public void setMax_exp(int max_exp) {
		Utilities.max_exp = max_exp;
	}

	/**
	 * @return the max_lev
	 */
	public static int getMax_lev() {
		return max_lev;
	}

	/**
	 * @param max_lev the max_lev to set
	 */
	public static void setMax_lev(int max_lev) {
		Utilities.max_lev = max_lev;
	}
}
