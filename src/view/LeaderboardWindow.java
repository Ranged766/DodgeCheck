package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

@SuppressWarnings("serial")
public class LeaderboardWindow extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JList list;
	private JButton btnExit;
	private JLabel lblTitle;
	private JButton btnReset;

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
		scrollPane.setBounds(10, 45, 258, 144);
		contentPane.add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);

		btnExit = new JButton("Exit\r\n");
		btnExit.setBounds(84, 200, 99, 38);
		contentPane.add(btnExit);

		lblTitle = new JLabel("Leaderboard\r\n");
		lblTitle.setBounds(10, 11, 274, 23);
		contentPane.add(lblTitle);

		btnReset = new JButton("Reset");
		btnReset.setBounds(316, 109, 89, 23);
		contentPane.add(btnReset);
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