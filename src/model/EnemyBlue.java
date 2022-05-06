package model;

public class EnemyBlue extends Enemy {

	public EnemyBlue(int x, int y, int sizeX, int sizeY, int speed, char direction) {
		super(x, y, sizeX, sizeY, speed, direction);
	}
	
	@Override
	public boolean isBlue() {
		return true;
	}
	
}
