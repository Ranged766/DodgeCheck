package main;

import view.MenuWindow;

import control.MenuController;

/**
 * Classe principale per l'avvio del programma.
 * 
 * @author Gruppo 7
 *
 */
public class ProgettoMain {

	public static void main(String[] args) {
		
		new MenuController(new MenuWindow());

	}

}	