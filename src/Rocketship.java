import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
void update() {
		
	}
void draw(Graphics Gr) {
	Gr.setColor(Color.BLUE);
	Gr.fillRect(x, y, width, height);
}
public Rocketship(int x,int y,int width,int height){
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
	this.speed=10;
}
}
