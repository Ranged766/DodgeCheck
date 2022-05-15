package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PlayerScore implements Serializable {
	private String nome;
	private int score;
	public PlayerScore(String nome, int score) {
		super();
		this.nome = nome;
		this.score = score;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Giocatore: " + nome + " || Punteggio: " + score;
	}
	
	
}
