import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame jFrame;
	final int WIDTH=500;
	final int HEIGHT=800;
	GamePanel g;
	public static void main(String[] args) {
		LeagueInvaders l=new LeagueInvaders();
	}
LeagueInvaders(){
	jFrame=new JFrame();
	g=new GamePanel();
	setup();
}
void setup(){
	jFrame.addKeyListener(g);
	jFrame.add(g);
	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jFrame.setSize(WIDTH, HEIGHT);
	jFrame.setVisible(true);
	g.startGame();
}
}
