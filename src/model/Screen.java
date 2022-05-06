package model;

public class Screen {
	// ------- WINDOW SIZE IS 4:3 ----------

		// screen size
		public static final int SCREEN_WIDTH = 800; // -------- CHANGE THIS TO CHANGE TO GAME SIZE --------

		// static final int SCREEN_HEIGHT = 600;
		public static final int SCREEN_HEIGHT = SCREEN_WIDTH / 4 * 3;

		// pixel size
		// static final int UNIT_SIZE = 10; // no auto-scale
		public static final int UNIT_SIZE = SCREEN_WIDTH / 100; // auto-scale

		// total pixel (not used)
		public static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);

		// delay
		public static final int DELAY = 8;
}
