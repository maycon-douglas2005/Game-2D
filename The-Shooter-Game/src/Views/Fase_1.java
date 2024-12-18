package Views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase_1 extends JPanel implements ActionListener {

	private Image fundo;
	private Player player;
	private Timer timer;
	private List<Enemy_1> enemy_1;

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
		inicializarInimigos();
	}
	
	public void inicializarInimigos() {
		int cordenadas [] = new int [40];
		enemy_1 = new ArrayList<Enemy_1>();
		
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int)(Math.random() * 8000+1024);
			int y = (int)(Math.random() * 650+30);
			enemy_1.add(new Enemy_1(x,y));
		}
	}
	

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;

		graficos.drawImage(fundo, 0, 0, null);

		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

		List<Tiro> tiros = player.getTiros();
		for (int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
			m.load();
			graficos.drawImage(m.getSkinDoTiro(), m.getX(), m.getY(), this);

		}
		
		for (int o = 0; o < enemy_1.size(); o++) {
			Enemy_1 in = enemy_1.get(o);
			in.load();
			graficos.drawImage(in.getSkinDoTiro(),in.getX(), in.getY(), this);
			
		}
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		List<Tiro> tiros = player.getTiros();
		for (int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
			if (m.isVisivel()) {
				m.update();
			} else {
				tiros.remove(i);
			}
		}
		
		
		for (int o = 0;  o < enemy_1.size(); o++) {
			Enemy_1 in = enemy_1.get(o);
			if(in.isVisivel()) {
				in.update();
			} else{
				enemy_1.remove(o);
			}
				
		}
		repaint();
		
	}

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
			
		}
	}
}
