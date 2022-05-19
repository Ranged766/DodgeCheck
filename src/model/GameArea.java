package model;

import java.awt.Rectangle;

/**
 * Classe contenente i valori statici della Game Area e della PLayer Area.
 * @author Gruppo 7
 *
 */
public class GameArea {
	/**
	 * Larghezza della game area.
	 */
	public static final int GAME_AREA_WIDTH = Screen.SCREEN_WIDTH / 4 * 3;
	/**
	 * Altezza della game area.
	 */
	public static final int GAME_AREA_HEIGHT = Screen.SCREEN_HEIGHT / 2;
	/**
	 * Posizione della game area nell'asse dell X.
	 */
	public static final int GAME_AREA_X = Screen.SCREEN_WIDTH / 2 - GAME_AREA_WIDTH / 2;
	/**
	 * Posizione della game area nell'asse dell Y.
	 */
	public static final int GAME_AREA_Y = Screen.SCREEN_HEIGHT / 2 - GAME_AREA_HEIGHT / 6;

	/**
	 * @Rectangle che delimita la zona di gioco del player.
	 */
	public static final Rectangle rGame = new Rectangle(GAME_AREA_X, GAME_AREA_Y, GAME_AREA_WIDTH, GAME_AREA_HEIGHT);
}
