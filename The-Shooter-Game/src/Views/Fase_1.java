package Views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase_1 extends JPanel{
	private Image fundo;
	
	
	public Fase_1() {
		ImageIcon referencia = new ImageIcon("src\\img\\cidade.jpg");
		fundo = referencia.getImage();
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		
		graficos.drawImage(fundo, 0, 0, null);
		g.dispose();
	}
}
