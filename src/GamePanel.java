import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Rocketship Rocket=new Rocketship(250,700,50,50);
	ObjectManager om=new ObjectManager();
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	//GameObject Ga;
	Font titleFont=new Font("Arial", Font.PLAIN, 48);
	Font smallFont=new Font("Arial", Font.PLAIN, 24);
	public GamePanel() {
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		timer = new Timer(1000 / 60, this);
		// Ga =new GameObject();
		om.addObject(Rocket);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		// Ga.update();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics Gr) {
		// Ga.draw(Gr);
		if(currentState == MENU_STATE){
			drawMenuState(Gr);
		}else if(currentState == GAME_STATE){
			drawGameState(Gr);
		}else if(currentState == END_STATE){
			drawEndState(Gr);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if (currentState==MENU_STATE) {
				currentState= GAME_STATE;
			}
			else if (currentState==GAME_STATE) {
				currentState= END_STATE;
			}
			else if(currentState== END_STATE){
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			Rocket.y = Rocket.y - Rocket.speed;
			Rocket.update();
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			Rocket.y = Rocket.y + Rocket.speed;
			Rocket.update();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			Rocket.x = Rocket.x - Rocket.speed;
			Rocket.update();
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			Rocket.x = Rocket.x + Rocket.speed;
			Rocket.update();
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			om.addObject(new Projectile(Rocket.x+22, Rocket.y-10, 5, 20));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public void updateMenuState() {
		
	}

	public void updateGameState() {
		om.update();
		om.manageEnemies();
		om.checkCollision();
		if (Rocket.isAlive==false) {
			currentState=END_STATE;
			JOptionPane.showMessageDialog(null, ("You killed "+om.getScore()+" enemies!"));
			om.reset();
			Rocket = new Rocketship(250,700,50,50);
			om.addObject(Rocket);
			
		}
	}

	public void updateEndState() {

	}
	public void drawMenuState(Graphics Gr){
		Gr.setColor(Color.cyan);
		Gr.fillRect(0, 0, 500, 800);
		Gr.setFont(titleFont);
		Gr.setColor(Color.black);
		Gr.drawString("LEAGUE INVADERS", 30, 100);
		Gr.setFont(smallFont);
		Gr.drawString("Press ENTER to start", 130, 200);
		Gr.drawString("Press SPACE for instructions", 110, 300);
		
	}
	public void drawGameState(Graphics Gr){
		Gr.setColor(Color.BLACK);
		Gr.fillRect(0, 0, 500, 800);
		om.draw(Gr);
		
	}
	public void drawEndState(Graphics Gr){
		Gr.setColor(Color.RED);
		Gr.fillRect(0, 0, 500, 800);
	}
}
