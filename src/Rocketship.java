import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
void update() {
	super.update();
	}
void draw(Graphics Gr) {
	Gr.drawImage(GamePanel.rocketImg, x, y, width, height, null);
}
public Rocketship(int x,int y,int width,int height){
	super();
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
	this.speed=10;
}
}
