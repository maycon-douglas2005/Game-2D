package Views;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {
	private int x,y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	private List <Tiro> tiros;
	
	boolean teclaDpressionada = false;
	boolean teclaKpressionada = false;
	boolean teclaApressionada = false;
	boolean teclaWpressionada = false;
	boolean teclaSpressionada = false;
	
	public Player() {
		this.x= 300;
		this.y=550;
		
		tiros = new ArrayList<Tiro>();
	}
	
	public void load() {
		ImageIcon referencia = new ImageIcon("src\\img\\Satoru-Gojo.png");
		imagem = referencia.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
	}
	
	public void update() {
		x += dx;
		y += dy;
		
	}
	
	public void tiroSimples() {
		this.tiros.add(new Tiro(x+largura, y + (altura-200)));
	}
	
	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_J) {
			tiroSimples();
		}
		if(codigo == KeyEvent.VK_SPACE) {
			y = 550;
		}
		if(codigo == KeyEvent.VK_W) {
			dy = -3;
			teclaWpressionada = true;
		}
		
		if(codigo == KeyEvent.VK_S) {
			dy = 3;
			teclaSpressionada = true;
		}
		
		if(codigo == KeyEvent.VK_A) {
			dx = -3;
			teclaApressionada = true;
		}
		
		
		if(codigo == KeyEvent.VK_D) {
			dx = 3;
			teclaDpressionada = true;
		}
		if(codigo == KeyEvent.VK_K) {
			teclaKpressionada = true;
		}
		
		if(teclaDpressionada && teclaKpressionada) {
			dx = 10;
			if(x == 988) {
				dx = 0;
				x = 300;
			}
		}
		if(teclaApressionada && teclaKpressionada) {
			dx = -10;
			if(x == 0) {
				dx = 0;
				x = 300;
			}
		}
		if(teclaKpressionada && teclaWpressionada) {
			dy = -10;
		}
		if(teclaKpressionada && teclaSpressionada) {
			dy = 10;
		}
	}
	
	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_W) {
			dy = 0;
			teclaWpressionada = false;
		}
		
		if(codigo == KeyEvent.VK_S) {
			dy = 0;
			teclaSpressionada = false;
		}
		
		if(codigo == KeyEvent.VK_A) {
			dx = 0;
			teclaApressionada = false;
		}
		
		
		if(codigo == KeyEvent.VK_D) {
			dx = 0;
			teclaDpressionada = false;
		}
		if(codigo == KeyEvent.VK_K) {
			dx = 0;
			teclaKpressionada = false;
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

	public List<Tiro> getTiros() {
		return tiros;
	}




	
	
	
	
}








