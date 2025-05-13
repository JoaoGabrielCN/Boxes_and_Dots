package board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Placar {

	private BitmapFont font;
	private int posX, posY;

	public Placar(boolean type) {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("CutePixel.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 50;
		font = new BitmapFont();
		font = generator.generateFont(parameter);

		if (type) {
			font.setColor(Color.BLUE);
			posX = 75;
			posY = 650;

		} else {
			font.setColor(Color.RED);
			posX = 350;
			posY = 650;

		}
	}

	public void draw(SpriteBatch batch, int ponto) {

		font.draw(batch, "PONTOS:" + ponto, posX, posY);

	}

	public void dispose() {
		font.dispose();
	}

}
