package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Leaderboard;
import model.PlayerScore;
import view.LeaderboardWindow;
import view.MenuWindow;

public class LeaderboardController implements ActionListener {

	private LeaderboardWindow v;
	private Leaderboard l;
	private MenuWindow mw;

	public LeaderboardController(MenuWindow mw) {
		this.mw = mw;
		this.l = new Leaderboard();
		v = new LeaderboardWindow();
		addActionListener();
		updateList();
	}

	private void addActionListener() {
		v.getBtnExit().addActionListener(this);
		v.getBtnReset().addActionListener(this);
	}

	@SuppressWarnings("unchecked")
	public void updateList() {
		updateFromFile();
		v.getList().setModel(l.update());
	}

	private void updateFromFile() {
		l = new Leaderboard();
		File f = Leaderboard.file;
		Scanner s;
		try {
			s = new Scanner(f);

			while (s.hasNextLine()) {
				String line = s.nextLine();
				String items[] = line.split("\\|");

				l.add(new PlayerScore(items[0], Integer.parseInt(items[1])));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == v.getBtnExit()) {
			v.setVisible(false);
			mw.setVisible(true);
		} else if (e.getSource() == v.getBtnReset()) {
			l.resetLeaderboard();
			updateList();
		}

	}

}
