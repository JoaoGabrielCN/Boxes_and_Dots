package telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Vector3;

public class Menu {
	private Texture  texture1, texture2;
	private Sprite  button1, button2;
	private Boolean gameBegin;
	private BitmapFont title, text1, text2;

	public Menu() {
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("CutePixel.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 80;
		title = new BitmapFont();
		title = generator.generateFont(parameter);
		
		text1 = new BitmapFont();
		text2 = new BitmapFont();
		
		parameter.size = 38;
		
		text1 = generator.generateFont(parameter);
		text2 = generator.generateFont(parameter);
		
		gameBegin = false;

		texture1 = new Texture("Botao.png");
		button1 = new Sprite(texture1);

		texture2 = new Texture("Botao.png");
		button2 = new Sprite(texture2);
	}
	public void setTextsPositions() {

		button1.setPosition(140, 390);
		button2.setPosition(140, 190);

		
	}

	public void drawMenu(SpriteBatch batch) {
		setTextsPositions();

		button1.draw(batch);
		button2.draw(batch);
		
		printTexts(batch);
	}

	public int testButtonClicked(OrthographicCamera camera) {

		Vector3 mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(mousePos);
		if (Gdx.input.justTouched()) {

			if (button1.getBoundingRectangle().contains(mousePos.x, mousePos.y)) {
				return 1;

			} else if (button2.getBoundingRectangle().contains(mousePos.x, mousePos.y)) {
				return 2;
			}
		}
		return 0;
	}

	public void dispose() {
		button1.getTexture().dispose();
		button2.getTexture().dispose();
		title.dispose();
		text1.dispose();
		text2.dispose();
	}

	public void setBeginGame(Boolean gameBegin) {
		this.gameBegin = gameBegin;
	}

	public Boolean getBeginGame() {
		return gameBegin;
	}
	
	private void printTexts(SpriteBatch batch) {
		title.setColor(Color.BLACK);
		title.draw(batch, "BOXS & DOTS", 115, 630);
		
		text1.setColor(Color.BLACK);
		text1.draw(batch, "Jogador x Jogador", 163, 432);
		
		text2.setColor(Color.BLACK);
		text2.draw(batch, "Jogador x Máquina", 163, 232);
	}
}