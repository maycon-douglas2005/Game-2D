package Views;

import javax.swing.JFrame;

public class Container extends JFrame{
	
	public Container() {
		setTitle("The Shooter");
		setSize(1024,728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		new Container();
	}
}
