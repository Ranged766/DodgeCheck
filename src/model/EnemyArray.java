package model;

import java.util.ArrayList;

public class EnemyArray {
	private ArrayList<Enemy> a;

	public EnemyArray() {
		this.a = new ArrayList<>();
	}
	
	public ArrayList<Enemy> getA() {
		return a;
	}

	public Enemy getEnemy(int pos) {
		return a.get(pos);
	}

	public void setEnemy(int pos, int x, int y, int sizeX, int sizeY,int speed, char direction) {
		this.a.set(pos, new Enemy(x, y, sizeX, sizeY, speed, direction));
	}
	
	public void create(int x, int y, int sizeX, int sizeY, int speed, char direction) {
		a.add(new Enemy(x, y, sizeX, sizeY, speed, direction));
	}
	
	public void createB(int x, int y, int sizeX, int sizeY, int speed, char direction) {
		a.add(new EnemyBlue(x, y, sizeX, sizeY, speed, direction));
	}
	
}