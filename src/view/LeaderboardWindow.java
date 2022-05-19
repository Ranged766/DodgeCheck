package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ImageIcon;

/**
 * Classe contenente la scheda della classifica.
 * @author user
 *
 */
@SuppressWarnings("serial")
public class LeaderboardWindow extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JList list;
	private JButton btnExit;
	private JLabel lblTitle;
	private JButton btnReset;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public LeaderboardWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 258, 144);
		contentPane.add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);

		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/exit.png")));
		btnExit.setBounds(307, 192, 98, 62);
		btnExit.setOpaque(false);
		btnExit.setFocusPainted(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setBorder(null);
		contentPane.add(btnExit);

		lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/leaderboard.png")));
		lblTitle.setBounds(10, 11, 275, 62);
		contentPane.add(lblTitle);

		btnReset = new JButton("");
		btnReset.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/Reset.png")));
		btnReset.setOpaque(false);
		btnReset.setFocusPainted(false);
		btnReset.setContentAreaFilled(false);
		btnReset.setBorderPainted(false);
		btnReset.setBorder(null);
		btnReset.setBounds(298, 95, 130, 62);
		contentPane.add(btnReset);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/background.png")));
		lblNewLabel.setBounds(0, 0, 438, 265);
		contentPane.add(lblNewLabel);
		this.setVisible(true);
	}

	@SuppressWarnings("rawtypes")
	public JList getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(JList list) {
		this.list = list;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}
}