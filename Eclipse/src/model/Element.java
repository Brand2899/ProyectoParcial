package model;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Element {
	protected PApplet app;
	protected int posX;
	protected int posY;
	protected String iconAddress;
	protected PImage icon;
	
	public Element(PApplet app, String iconAddress, int posX, int posY) {
		this.app = app;
		this.iconAddress = iconAddress;
		this.posX = posX;
		this.posY = posY;
		
		icon = app.loadImage(iconAddress);
	}
	
	public abstract void draw();
}
