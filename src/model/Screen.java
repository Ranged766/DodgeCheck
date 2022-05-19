package model;

/**
 * Classe contenente i valori statici dello Schermo e del tempo di gioco.
 * @author Gruppo 7
 *
 */
public class Screen {
	
	/**
	 * Larghezza dello schermo.
	 */
	public static final int SCREEN_WIDTH = 800;
	
	/**
	 * Altezza dello schermo.
	 */
	public static final int SCREEN_HEIGHT = SCREEN_WIDTH / 4 * 3;

	/**
	 * Dimensione di una unità di gioco.
	 */
	public static final int UNIT_SIZE = SCREEN_WIDTH / 100;

	/**
	 * Ritardo del timer.
	 */
	public static final int DELAY = 8;
}
