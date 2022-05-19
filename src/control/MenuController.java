package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MenuWindow;
import view.GamePanel;

/**
 * Classe che funge da controller per il @MenuWindow.
 * @author Gruppo 7
 *
 */
public class MenuController implements ActionListener{
	
	MenuWindow mw;
	
	/**
	 * Metodo costruttore della classe @MenuController.
	 * @param mw istanza del @MenuWindow
	 */
	public MenuController(MenuWindow mw) {
		this.mw = mw;
		this.eventi();
	}
	
	private void eventi() {
		mw.getBtnStart().addActionListener(this);
		mw.getBtnLeaderboard().addActionListener(this);
		mw.getBtnExit().addActionListener(this);
	}

	/**
	 * Implementazione del @ActionListener. Gestisce il navigamento nel menu.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mw.getBtnStart()) {
			new GameController(mw, new GamePanel());
			mw.setVisible(false);
		}
		if(e.getSource()==mw.getBtnLeaderboard()) {
			new LeaderboardController(mw);
			mw.setVisible(false);
		}
		if(e.getSource()==mw.getBtnExit()) {
			System.exit(0);
		}
	}

}
