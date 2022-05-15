package view;

import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame{

	public GameFrame(GamePanel gp){			

		this.add(gp);

		this.setTitle("Dodge Check");
		

		this.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuWindow.class.getResource("/img/icon.png")));

		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setResizable(false);

		this.pack();

		this.setLocationRelativeTo(null);

	}

}