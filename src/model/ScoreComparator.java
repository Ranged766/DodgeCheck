package model;

import java.util.Comparator;

/**
 * Classe che implemente @Comparator, utilizzata per comparare due @PlayerScore.
 * @author Gruppo 7
 *
 */
public class ScoreComparator implements Comparator<PlayerScore>{

	/**
	 * Confronta due @PlayerScore in base al loro punteggio.
	 */
	@Override
	public int compare(PlayerScore a, PlayerScore b) {
		return Integer.compare(a.getScore(), b.getScore()) * -1;
	}


}
