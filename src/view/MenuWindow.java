package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MenuWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnStart;
	private JLabel lblImgLeft;
	private JLabel lblTitle;
	private JButton btnExit;
	private JButton btnLeaderboard;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MenuWindow() {
		setBackground(new Color(0, 0, 0));
		setTitle("Dodge Check");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuWindow.class.getResource("/img/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(MenuWindow.class.getResource("/img/title.png")));
		lblTitle.setBounds(10, 11, 400, 197);
		panel.add(lblTitle);

		lblImgLeft = new JLabel("");
		lblImgLeft.setIcon(new ImageIcon(MenuWindow.class.getResource("/img/ghostm.gif")));
		lblImgLeft.setBounds(431, 93, 300, 387);
		panel.add(lblImgLeft);

		btnStart = new JButton("");
		btnStart.setIcon(new ImageIcon(MenuWindow.class.getResource("/img/Start.png")));
		btnStart.setBounds(145, 219, 135, 61);

		// per bottone opaco{
		btnStart.setBorder(null);
		btnStart.setBorderPainted(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setOpaque(false);
		btnStart.setFocusPainted(false);
		// }
		panel.add(btnStart);

		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(MenuWindow.class.getResource("/img/exit.png")));
		btnExit.setOpaque(false);
		btnExit.setFocusPainted(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setBorder(null);
		btnExit.setBounds(155, 363, 108, 69);
		panel.add(btnExit);

		btnLeaderboard = new JButton("");
		btnLeaderboard.setIcon(new ImageIcon(MenuWindow.class.getResource("/img/leaderboard.png")));
		btnLeaderboard.setOpaque(false);
		btnLeaderboard.setFocusPainted(false);
		btnLeaderboard.setContentAreaFilled(false);
		btnLeaderboard.setBorderPainted(false);
		btnLeaderboard.setBorder(null);
		btnLeaderboard.setBounds(102, 291, 233, 61);
		panel.add(btnLeaderboard);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuWindow.class.getResource("/img/background.png")));
		lblNewLabel.setBounds(-15, 0, 793, 555);
		panel.add(lblNewLabel);


		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public JButton getBtnLeaderboard() {
		return btnLeaderboard;
	}
}
