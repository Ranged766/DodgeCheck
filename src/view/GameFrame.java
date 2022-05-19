package view;

import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Frame contenente il @GamePanel.
 * 
 * @author Gruppo 7
 *
 */
@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	/**
	 * Metodo costruttore del @GameFrame.
	 * @param gp istanza di @GamePanel
	 */
	public GameFrame(GamePanel gp) {

		this.add(gp);

		this.setTitle("Dodge Check");

		this.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuWindow.class.getResource("/img/icon.png")));

		this.setResizable(false);

		this.pack();

		this.setLocationRelativeTo(null);

	}

}