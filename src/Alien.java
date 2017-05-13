import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	public Alien(int x,int y,int width,int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	void update(){
		y++;
	}
	void draw(Graphics Gr){
		Gr.setColor(Color.YELLOW);
		Gr.drawRect(x, y, width, height);
	}
}
