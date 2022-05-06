package model;

import java.awt.Rectangle;

public class GameArea {
	// game area size
	public static final int GAME_AREA_WIDTH = Screen.SCREEN_WIDTH / 4 * 3;

	public static final int GAME_AREA_HEIGHT = Screen.SCREEN_HEIGHT / 2;

	public static final int GAME_AREA_X = Screen.SCREEN_WIDTH / 2 - GAME_AREA_WIDTH / 2;

	public static final int GAME_AREA_Y = Screen.SCREEN_HEIGHT / 2 - GAME_AREA_HEIGHT / 6;

	// game area rectangle
	public static final Rectangle rGame = new Rectangle(GAME_AREA_X, GAME_AREA_Y, GAME_AREA_WIDTH, GAME_AREA_HEIGHT);
}
