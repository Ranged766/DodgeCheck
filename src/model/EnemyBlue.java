package model;

/**
 * Variazione di @Enemy.
 * @author Gruppo 7
 *
 */
public class EnemyBlue extends Enemy {

	private boolean scored = false;
	
	/**
	 * Metodo costruttore della classe @EnemyBlue.
	 * @param x	posizione nell'asse x
	 * @param y posizione nell'asse y
	 * @param sizeX dimensione nell'asse x
	 * @param sizeY dimensione nell'asse y
	 * @param speed	velocita in pixel/frame
	 * @param direction	direzione dall'altro(T) o dai lati(S)
	 */
	public EnemyBlue(int x, int y, int sizeX, int sizeY, int speed, char direction) {
		super(x, y, sizeX, sizeY, speed, direction);
	}
	
	@Override
	public boolean isBlue() {
		return true;
	}

	public boolean isScored() {
		return scored;
	}

	public void setScored(boolean scored) {
		this.scored = scored;
	}
	
}
