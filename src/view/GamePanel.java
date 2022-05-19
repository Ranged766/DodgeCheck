package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Enemy;
import model.EnemyArray;
import model.GameArea;
import model.Player;
import model.Score;
import model.Screen;

/**
 * Classe contenente la schermata di gioco.
 * 
 * @author Gruppo 7
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	Graphics g;
	Boolean end = false;

	Player player = new Player();
	EnemyArray enemy = new EnemyArray();
	Score score = new Score();

	/**
	 * Metodo costruttore del @GamePanel.
	 */
	public GamePanel() {
		// create window
		this.setPreferredSize(new Dimension(Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT));

		this.setBackground(Color.black);

		this.setFocusable(true);

	}

	/**
	 * Metodo che chiama i vari metodi necessari al draw del pannello.
	 * 
	 * @param player istanza di @Player
	 * @param enemy  istanza di @EnemyArray
	 * @param score  istanza di @Score
	 */
	public void callRepaint(Player player, EnemyArray enemy, Score score) {
		this.player = player;
		this.enemy = enemy;
		this.score = score;
		repaint();
	}

	/**
	 * Metodo chiamto per il draw del pannello.
	 */
	public void paintComponent(Graphics g) {
		this.g = g;
		// reset the 'window'
		super.paintComponent(g);

		// draw the position of every element
		if (!end)
			draw(g);
		else
			drawEnd();

	}

	/**
	 * Metodo utilizzato per rappresentare a schermo il gioco.
	 * 
	 * @param g istanza di @Graphics
	 */
	public void draw(Graphics g) {

		// write score
		g.setColor(Color.red);

		g.setFont(new Font("Arcade", Font.BOLD, 30));

		FontMetrics metrics2 = getFontMetrics(g.getFont());

		g.drawString("SCORE", (Screen.SCREEN_WIDTH - metrics2.stringWidth("SCORE")) / 2, 30 + Screen.UNIT_SIZE);
		g.drawString("" + score.getScore(), (Screen.SCREEN_WIDTH - metrics2.stringWidth("" + score.getScore())) / 2,
				30 + Screen.UNIT_SIZE + 30);

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(getClass().getResource("cuore.png").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		g.drawImage(image, player.getX(), player.getY(), Screen.UNIT_SIZE, Screen.UNIT_SIZE, null);

		// draw game area
		g.setColor(Color.white);

		g.drawRect(GameArea.GAME_AREA_X, GameArea.GAME_AREA_Y, GameArea.GAME_AREA_WIDTH, GameArea.GAME_AREA_HEIGHT);

		// draw enemy
		for (Enemy x : enemy.getA()) {

			Rectangle rEnemy = new Rectangle(x.getX(), x.getY(), x.getSizeX(), x.getSizeY());
			Rectangle inters = new Rectangle(rEnemy.intersection(GameArea.rGame));
			if (inters.getWidth() > 0 && inters.getHeight() > 0) {
				if (x.isBlue())
					g.setColor(Color.cyan);
				else
					g.setColor(Color.white);
				g.fillRect((int) inters.getX(), (int) inters.getY(), (int) inters.getWidth(), (int) inters.getHeight());
			}

		}
	}

	/**
	 * Stampa il testo di game over.
	 */
	public void drawEnd() {
		// Game Over text
		g.setColor(Color.red);

		g.setFont(new Font("Verdana", Font.BOLD, 75));

		FontMetrics metrics2 = getFontMetrics(g.getFont());

		g.drawString("GAME OVER", (Screen.SCREEN_WIDTH - metrics2.stringWidth("GAME OVER")) / 2,
				Screen.SCREEN_HEIGHT / 4);
	}

	/**
	 * Metodo chimato per mostrare la schermata di game over e richiedere il nome.
	 * del player.
	 * 
	 * @return Nome del player
	 */
	public String gameOver() {

		end = true;
		repaint();

		return JOptionPane.showInputDialog("What is your name?", null);
	}

	/**
	 * Metodo che mostra una conferma dell'inserimento del punteggio.
	 */
	public void showConfirmation() {

		JOptionPane.showMessageDialog(null, "Punteggio salvato!");
	}
}