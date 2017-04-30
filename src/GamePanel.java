import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	GameObject Ga;
	GamePanel() {
		timer = new Timer(1000 / 60, this);
		Ga =new GameObject();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		Ga.update();
	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics Gr) {
		Ga.draw(Gr);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("1");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("2");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("3");
		
	}

}
