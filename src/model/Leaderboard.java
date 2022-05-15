package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;

public class Leaderboard {
	public static File file = new File("leaderboard.dat");
	private ArrayList<PlayerScore> a;
	
	public Leaderboard() {
		a = new ArrayList<>();
	}
	
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

	public DefaultListModel<PlayerScore> update() {
		Collections.sort(a, new ScoreComparator());
		DefaultListModel<PlayerScore> modello = new DefaultListModel<PlayerScore>();
		for(PlayerScore x: a) {
			modello.addElement(x);
		}
		return modello;
	}
	
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
