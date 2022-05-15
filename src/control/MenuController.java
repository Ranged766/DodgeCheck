package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MenuWindow;
import view.GamePanel;

public class MenuController implements ActionListener{
	
	MenuWindow mw;
	
	public MenuController(MenuWindow mw) {
		this.mw = mw;
		this.eventi();
	}
	
	public void eventi() {
		mw.getBtnStart().addActionListener(this);
		mw.getBtnLeaderboard().addActionListener(this);
		mw.getBtnExit().addActionListener(this);
	}

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
