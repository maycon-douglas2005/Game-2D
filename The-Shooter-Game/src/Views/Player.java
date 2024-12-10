package Views;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {
	private int x,y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	
	public Player() {
		this.x= 300;
		this.y=500;
	}
	
	public void load() {
		ImageIcon referencia = new ImageIcon("src\\img\\protagonista-direita.jpeg");
		imagem = referencia.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		System.out.println("Metodo load chamado");
	}
	
	public void update() {
		x += dx;
		y += dy;
		
	}
	
	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		System.out.println("Dentro do keyPressed do Player");
		if(codigo == KeyEvent.VK_UP) {
			dy = -3;
			System.out.println("Tecla pra cima pressionada");
		}
		
		if(codigo == KeyEvent.VK_DOWN) {
			dy = 3;
		}
		
		if(codigo == KeyEvent.VK_LEFT) {
			dx = -3;
		}
		
		
		if(codigo == KeyEvent.VK_RIGHT) {
			dx = 3;
		}
	}
	
	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		System.out.println("Dentro do keyRelease");
		if(codigo == KeyEvent.VK_UP) {
			dy = 0;
			System.out.println("Dentro do keyRelease da tecla cima");
		}
		
		if(codigo == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		
		if(codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		
		
		if(codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}




	
	
	
	
}








