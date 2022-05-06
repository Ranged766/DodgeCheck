package view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame{

	public GameFrame(){			

		this.add(new GamePanel());

		this.setTitle("Progetto");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setResizable(false);

		this.pack();

		this.setVisible(true);

		this.setLocationRelativeTo(null);

	}

}