package Views;

import javax.swing.JFrame;

public class Container extends JFrame{
	
	public Container() {
		add(new Fase_1());
		
		setVisible(true);
		setTitle("Jujutsu Kaisen");
		setSize(1024, 700);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		new Container();
	}
}