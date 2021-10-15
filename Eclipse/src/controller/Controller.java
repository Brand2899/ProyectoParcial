package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {
	
	private PApplet app;
	private Logic l;
	
	public Controller(PApplet app) {
		this.app = app;
		l = new Logic(app);
	}
	
	public void draw() {
		l.draw();
	}
	
	public void move() {
		l.moveP1();
		l.moveP2();
	}
	
	public void jumpP1() {
		l.jumpP1();
	}
	
	public void jumpP2() {
		l.jumpP2();
	}
}