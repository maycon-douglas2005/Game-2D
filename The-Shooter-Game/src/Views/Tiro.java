package Views;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

public class Tiro {
	private Image skinDoTiro;
	private int x,y,largura, altura;
	private boolean isVisivel;
	
	
	
	private static final int LARGURA = 700;
	
	private static final int VELOCIDADE = 2;
	
	
	public Tiro (int x, int y) {
		this.x = x;
		this.y = y;
		isVisivel = true;
	}
	
	public void load() {
		ImageIcon referencia = new ImageIcon("src\\img\\tiro.png");
		skinDoTiro = referencia.getImage();
		
		this.altura = skinDoTiro.getHeight(null);
		this.largura = skinDoTiro.getWidth(null);
		
	}
	
	public void update() {
		this.x += VELOCIDADE;
		
		if(this.x > 700) {
			isVisivel = false;
		}
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static int getVelocidade() {
		return VELOCIDADE;
	}

	public Image getSkinDoTiro() {
		return skinDoTiro;
	}
	
	
	
	
}
