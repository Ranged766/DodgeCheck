package model;

import java.util.Comparator;

public class ScoreComparator implements Comparator<PlayerScore>{

	@Override
	public int compare(PlayerScore a, PlayerScore b) {
		return Integer.compare(a.getScore(), b.getScore()) * -1;
	}


}
