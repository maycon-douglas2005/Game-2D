package Views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase_1 extends JPanel implements ActionListener{
	
	private Image fundo;
	private Player player;
	private Timer timer;
	
	
	public Fase_1() {
		
		setFocusable(true); // Garante que o painel pode receber foco 
		requestFocusInWindow(); // Solicita o foco para o painel
		
		ImageIcon referencia = new ImageIcon("src\\img\\cidade.jpg");
		fundo = referencia.getImage();
		
		player = new Player();
		player.load();
		
		addKeyListener(new TecladoAdapter());
		
		
		timer = new Timer(5, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		
		graficos.drawImage(fundo, 0, 0, null);
		
		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		repaint();
	//	System.out.println("Dentro do metodo actionPerformed da fase"); FUNCIONA
	}
	
	
	
	private class TecladoAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
			System.out.println("Metodo keyPressed ativo da fase1");
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
			System.out.println("Metodo keyRelease ativo da fase1");
		}
	}
}






