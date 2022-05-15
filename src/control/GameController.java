package control;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.Timer;

import model.Enemy;
import model.EnemyArray;
import model.EnemyBlue;
import model.GameArea;
import model.Leaderboard;
import model.Player;
import model.Score;
import model.Screen;
import view.GameFrame;
import view.GamePanel;
import view.MenuWindow;

public class GameController implements ActionListener, WindowListener {

	MenuWindow mw;
	GamePanel gp;
	GameFrame gf;

	// player
	Player player = new Player();

	// enemy matrix
	EnemyArray enemy = new EnemyArray();

	// running flag
	boolean running = false;

	// score counter
	Score score = new Score();

	// create timer
	Timer timer;

	// random
	Random random;

	// temp switch move enemy
	boolean moveE;

	public GameController(MenuWindow mw, GamePanel gp) {
		this.mw = mw;
		this.gp = gp;

		// launch startup method
		startGame();

		// key listener for movement
		gp.addKeyListener(new MyKeyAdapter());
		
		gf.addWindowListener(this);

		gf.setVisible(true);
	}

	// startup method
	public void startGame() {

		gf = new GameFrame(gp);

		running = true;

		// set and launch timer
		timer = new Timer(Screen.DELAY, this);

		timer.start();

		// random
		random = new Random();

		// start position
		player.setX(Screen.SCREEN_WIDTH / 2 - Screen.UNIT_SIZE);
		player.setY(Screen.SCREEN_HEIGHT / 6 * 4);

		// create enemy
		createEnemy();

	}

	public void newGame() {
		gf.setVisible(false);
		gf.dispose();

		player = new Player();
		enemy = new EnemyArray();
		score = new Score();
		moveE = false;

		startGame();
	}

	// create enemy
	public void createEnemy() {

		int enemyDimX = 0;
		int enemyDimY = 0;

		for (int i = 0; i < 10; i++) {
			enemyDimX = random.nextInt(21) + 10;
			enemyDimY = random.nextInt(21) + 10;
			enemy.create(random.nextInt(600), 0, enemyDimX, enemyDimY, random.nextInt(1) + 1, 'S');
		}

		for (int i = 0; i < 10; i++) {
			enemyDimX = random.nextInt(21) + 10;
			enemyDimY = random.nextInt(21) + 10;
			enemy.create(0, random.nextInt(400), enemyDimX, enemyDimY, random.nextInt(1) + 1, 'T');
		}

		enemy.createB(0, random.nextInt(200), random.nextInt(21) + 10, random.nextInt(21) + 10, 2, 'T');

	}

	// move method
	public void move() {

		int slow = 2;

		if (player.isShift())
			slow *= 2;

		if (player.getDirection(0) == true)

			player.setY(player.getY() - Screen.UNIT_SIZE / slow);

		if (player.getDirection(1) == true)

			player.setY(player.getY() + Screen.UNIT_SIZE / slow);

		if (player.getDirection(2) == true)

			player.setX(player.getX() - Screen.UNIT_SIZE / slow);

		if (player.getDirection(3) == true)

			player.setX(player.getX() + Screen.UNIT_SIZE / slow);

	}

	// move enemy
	public void moveEnemy() {
		if (moveE) {
			moveE = false;
			for (Enemy x : enemy.getA()) {
				switch (x.getDirection()) {
				// from side
				case 'S':
					if (x.getX() < Screen.SCREEN_WIDTH) {
						x.setX(x.getX() + x.getSpeed());
					} else {
						x.setSizeX(random.nextInt(21) + 10);
						x.setSizeY(random.nextInt(21) + 10);
						x.setX(0);
						x.setY(random.nextInt(GameArea.GAME_AREA_HEIGHT) + GameArea.GAME_AREA_Y);
						int randa = (int) Math.floor((double) random.nextInt(100) / (65 + x.getSpeed() * 2));
						// System.out.println(randa);
						x.setSpeed(x.getSpeed() + randa);
						score.setScore(score.getScore() + 1);
						if (x.isBlue() && random.nextInt(3) == 1) {
							EnemyBlue eb = (EnemyBlue) x;
							eb.setScored(false);
							x.setDirection('T');
							x.setX(random.nextInt(GameArea.GAME_AREA_WIDTH) + GameArea.GAME_AREA_X);
							x.setY(100);
						}
					}
					break;
				// from top
				case 'T':
					if (x.getY() < Screen.SCREEN_HEIGHT) {
						x.setY(x.getY() + x.getSpeed());
					} else {
						x.setSizeX(random.nextInt(21) + 10);
						x.setSizeY(random.nextInt(21) + 10);
						x.setY(200);
						x.setX(random.nextInt(GameArea.GAME_AREA_WIDTH) + GameArea.GAME_AREA_X);
						int randa = (int) Math.floor((double) random.nextInt(100) / (80 + x.getSpeed() * 2));
						// int chance = 100 - (80 + x.getSpeed() * 2);
						// System.out.println("chance: " + chance);
						// System.out.println("rand " + randa);
						x.setSpeed(x.getSpeed() + randa);
						// System.out.println("speed " + x.getSpeed());
						score.setScore(score.getScore() + 1);
						if (x.isBlue() && random.nextInt(3) == 1) {
							EnemyBlue eb = (EnemyBlue) x;
							eb.setScored(false);
							x.setDirection('S');
							x.setX(0);
							x.setY(random.nextInt(GameArea.GAME_AREA_HEIGHT) + GameArea.GAME_AREA_Y);
						}
					}
					break;
				}
			}
		} else
			moveE = true;
	}

	public void checkCollisions() {

		// check if player touches left border

		if (player.getX() < GameArea.GAME_AREA_X) {

			player.setX(GameArea.GAME_AREA_X + 1); // border + 1 pixel to push the
													// player out of the
			// border

		}

		// check if player touches right border

		if (player.getX() > (GameArea.GAME_AREA_X + GameArea.GAME_AREA_WIDTH - Screen.UNIT_SIZE)) {

			player.setX((GameArea.GAME_AREA_X) + GameArea.GAME_AREA_WIDTH - Screen.UNIT_SIZE - 1); // border - 1 pixel
			// to push
			// the player out of the
			// border

		}

		// check if player touches top border

		if (player.getY() < GameArea.GAME_AREA_Y) {

			player.setY(GameArea.GAME_AREA_Y + 1); // border + 1 pixel to push the
													// player out of the
			// border

		}

		// check if player touches bottom border

		if (player.getY() > GameArea.GAME_AREA_Y + GameArea.GAME_AREA_HEIGHT - Screen.UNIT_SIZE) {

			player.setY(GameArea.GAME_AREA_Y + GameArea.GAME_AREA_HEIGHT - Screen.UNIT_SIZE - 1); // border - 1
																									// pixel to
			// push the player out
			// of the border

		}

		// check enemy collision
		Rectangle rPlayer = new Rectangle(player.getX(), player.getY(), Screen.UNIT_SIZE, Screen.UNIT_SIZE);

		for (Enemy en : enemy.getA()) {
			Rectangle rEnemy = new Rectangle(en.getX(), en.getY(), en.getSizeX(), en.getSizeY());
			Rectangle inters = new Rectangle(rEnemy.intersection(rPlayer));
			if (inters.getWidth() > 0 && inters.getHeight() > 0)
				if (!en.isBlue())
					running = false;
				else if (player.isMoving())
					running = false;
				else {
					EnemyBlue eb = (EnemyBlue) en;
					if (!eb.isScored()) {
						score.setScore(score.getScore() + 10);
						eb.setScored(true);
					}
				}
		}

		// stop timer if game ended
		if (!running) {

			timer.stop();

		}

	}

	private void loadOnFile(String name) {

		Leaderboard l = new Leaderboard();
		l.writeToFile(name, score.getScore());
	}

	// method in use every timer call (DELAY)
	public void actionPerformed(ActionEvent e) {

		if (running) {

			// move then check for collisions
			move();

			checkCollisions();

			// move enemy
			moveEnemy();

		}
		if (running)
			// call the paint component method
			gp.callRepaint(player, enemy, score);
		else
			gameOver();

	}

	// game over method
	public void gameOver() {
		String name = gp.gameOver();

		if (name != null) {

			loadOnFile(name);
			gp.showConfirmation();

		}

		gf.setVisible(false);
		gf.dispose();

		mw.setVisible(true);

	}

	// input method
	public class MyKeyAdapter extends KeyAdapter {

		@Override
		// mark the flag as true if the key is pressed
		public void keyPressed(KeyEvent e) {

			switch (e.getKeyCode()) {

			case KeyEvent.VK_UP:
				player.setDirection(0, true);
				break;
			case KeyEvent.VK_DOWN:
				player.setDirection(1, true);
				break;
			case KeyEvent.VK_LEFT:
				player.setDirection(2, true);
				break;
			case KeyEvent.VK_RIGHT:
				player.setDirection(3, true);
				break;
			case KeyEvent.VK_SHIFT:
				player.setShift(true);
				break;
			case KeyEvent.VK_R:

			}

		}

		@Override
		// mark the flag as false if the key is lifted
		public void keyReleased(KeyEvent e) {

			switch (e.getKeyCode()) {

			case KeyEvent.VK_UP:
				player.setDirection(0, false);
				break;
			case KeyEvent.VK_DOWN:
				player.setDirection(1, false);
				break;
			case KeyEvent.VK_LEFT:
				player.setDirection(2, false);
				break;
			case KeyEvent.VK_RIGHT:
				player.setDirection(3, false);
				break;
			case KeyEvent.VK_SHIFT:
				player.setShift(false);
				break;

			}
		}

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {		//	serve fixare
		// TODO Auto-generated method stub
		gf.dispose();
		mw.setVisible(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
