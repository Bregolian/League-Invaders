import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;

	void update() {
		y+=3;
	}

	void draw(Graphics Gr) {
		Gr.fillRect(x, y, 100, 100);
	}
}
