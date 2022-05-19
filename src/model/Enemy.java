package model;

/**
 * Classe contenente tutti i valori dei nemici.
 * @author Gruppo 7
 *
 */
public class Enemy {
	private int x;
	private int y;
	private int sizeX;
	private int sizeY;
	private int speed;
	private char direction;
	
	/**
	 * Metodo costruttore della classe @Enemy.
	 * @param x	posizione nell'asse x
	 * @param y posizione nell'asse y
	 * @param sizeX dimensione nell'asse x
	 * @param sizeY dimensione nell'asse y
	 * @param speed	velocita in pixel/frame
	 * @param direction	direzione dall'altro(T) o dai lati(S)
	 */
	public Enemy(int x, int y,int sizeX, int sizeY, int speed, char direction) {
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.speed = speed;
		this.direction = direction;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean isBlue() {
		return false;
	}
	
}