package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;

/**
 * Classe contenente la classifica di @PlayerScore.
 * @author Gruppo 7
 *
 */
public class Leaderboard {
	/**
	 * Attributo statico contenente il nome del file.
	 */
	public static File file = new File("leaderboard.dat");
	private ArrayList<PlayerScore> a;
	
	/**
	 * Metodo di costruzione della classe @Leaderboard.
	 */
	public Leaderboard() {
		a = new ArrayList<>();
	}
	
	/**
	 * Metodo c he aggiunge un nuovo @PlayerScore alla classifica.
	 * @param x istanza di @PlayerScore
	 */
	public void add(PlayerScore x) {
		a.add(x);
	}
	
	public ArrayList<PlayerScore> getA() {
		return a;
	}
	
	public void setA(ArrayList<PlayerScore> a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "Leaderboard [a=" + a + "]";
	}

	/**
	 * Metodo che ritorna un @DefaultListModel utilizzato dal @LeaderboardWindow per mostrare la classifica.
	 * @return @DefaultListModel contente la classifica
	 */
	public DefaultListModel<PlayerScore> update() {
		Collections.sort(a, new ScoreComparator());
		DefaultListModel<PlayerScore> modello = new DefaultListModel<PlayerScore>();
		for(PlayerScore x: a) {
			modello.addElement(x);
		}
		return modello;
	}
	
	/**
	 * Metodo che resetta la classifica.
	 */
	public void resetLeaderboard() {
		a = new ArrayList<>();
		try {
			PrintWriter writer = new PrintWriter(file);
			writer.print("");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo utilizatto per scrivere sul file.
	 * @param name nome del player
	 * @param score punteggio del player
	 */
	public void writeToFile(String name, int score) {
		File f = Leaderboard.file;
		try {
			
			FileWriter fw = new FileWriter(f, true);
			
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(name + "|" + score);
			
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
