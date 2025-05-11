package board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Placar {
	
	BitmapFont font;
	
	int posX,posY;
	int tipo;
	
	
	public Placar(int tipo) {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("CutePixel.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 32; 
		font = new BitmapFont();
		font = generator.generateFont(parameter);
		this.tipo = tipo;
		font.getData().setScale(2f); 
	}
	
	public void render() {
		if(tipo==0) {
			font.setColor(Color.BLUE);
			posX=75;
			posY=650;
			
		}
		if(tipo==1) {
			font.setColor(Color.RED);
			posX=350;
			posY=650;
			
		}
		
	}
	
	public void draw(SpriteBatch batch, int ponto) {
		
		font.draw(batch, "PONTOS:"+ ponto, posX, posY);
		
		
	}
	
	public void dispose() {
		font.dispose();
	}
	

}
