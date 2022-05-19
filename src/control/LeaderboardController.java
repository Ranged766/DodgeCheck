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

/**
 * Classe che funge da controller per la @Leaderboard.
 * 
 * @author Gruppo 7
 *
 */
public class LeaderboardController implements ActionListener {

	private LeaderboardWindow v;
	private Leaderboard l;
	private MenuWindow mw;

	/**
	 * Metodo costruttore della classe @LeaderboardController.
	 * @param mw istanza del @MenuWindow
	 */
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

	/**
	 * Metodo utilizzato per aggiornare la @Leaderboard con i valori presenti nel file.
	 */
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

	/**
	 * Implementazione del @ActionListener. Gestisce l'uscita e il reset della finestra Leaderboard.
	 */
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
