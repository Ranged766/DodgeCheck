package main;

import view.MenuWindow;

import control.MenuController;

public class ProgettoMain {

	public static void main(String[] args) {
		
		MenuWindow mw = new MenuWindow();
		new MenuController(mw);

	}

}	