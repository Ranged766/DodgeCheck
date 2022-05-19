package model;

import java.util.ArrayList;

/**
 * Classe contenente un array di @Enemy.
 * @author Gruppo 7
 *
 */
public class EnemyArray {
	private ArrayList<Enemy> a;

	/**
	 * Metodo costruttore del @EnemyArray.
	 */
	public EnemyArray() {
		this.a = new ArrayList<>();
	}
	
	public ArrayList<Enemy> getA() {
		return a;
	}

	/**
	 * Ritorno @Enemy presente nella posiozione richiesta.
	 * @param pos posizione nell'array
	 * @return elemento nella posizione richiesta
	 */
	public Enemy getEnemy(int pos) {
		return a.get(pos);
	}

	/**
	 * Imposta delle nuove specifiche all'elemento nella posizione specificata.
	 * @param pos posizione nell'array
	 * @param x posizione nell'asse x
	 * @param y posizione nell'asse y
	 * @param sizeX dimensione nell'asse x
	 * @param sizeY dimensione nell'asse y
	 * @param speed velocità in pixel/frame
	 * @param direction direzione dall'altro(T) o dai lati(S)
	 */
	public void setEnemy(int pos, int x, int y, int sizeX, int sizeY,int speed, char direction) {
		this.a.set(pos, new Enemy(x, y, sizeX, sizeY, speed, direction));
	}
	
	/**
	 * Crea un nuovo @Enemy nell'array.
	 * @param x posizione nell'asse x
	 * @param y posizione nell'asse y
	 * @param sizeX dimensione nell'asse x
	 * @param sizeY dimensione nell'asse y
	 * @param speed velocità in pixel/frame
	 * @param direction direzione dall'altro(T) o dai lati(S)
	 */
	public void create(int x, int y, int sizeX, int sizeY, int speed, char direction) {
		a.add(new Enemy(x, y, sizeX, sizeY, speed, direction));
	}
	
	/**
	* Crea un nuovo @EnemyBlue nell'array.
	 * @param x posizione nell'asse x
	 * @param y posizione nell'asse y
	 * @param sizeX dimensione nell'asse x
	 * @param sizeY dimensione nell'asse y
	 * @param speed velocità in pixel/frame
	 * @param direction direzione dall'altro(T) o dai lati(S)
	 */
	public void createB(int x, int y, int sizeX, int sizeY, int speed, char direction) {
		a.add(new EnemyBlue(x, y, sizeX, sizeY, speed, direction));
	}
	
}