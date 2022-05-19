package model;

import java.io.Serializable;

/**
 * Classe contenente i valori di un punteggio.
 * @author Gruppo 7
 *
 */
@SuppressWarnings("serial")
public class PlayerScore implements Serializable {
	private String nome;
	private int score;
	/**
	 * Metodo costruttore della classe @PlayerScore.
	 * @param nome nome del giocatore
	 * @param score punteggio del giocatore
	 */
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
