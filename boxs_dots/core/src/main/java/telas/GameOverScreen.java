package telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class GameOverScreen {
	private BitmapFont winnerText, resetText;
	private int resetPosX, resetPosY, winnerPosX, winnerPosY;

	public GameOverScreen() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("CutePixel.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 50;

		winnerPosX = 50;
		winnerPosY = 450;

		resetPosX = 160;
		resetPosY = 250;

		winnerText = new BitmapFont();
		winnerText = generator.generateFont(parameter);

		resetText = new BitmapFont();
		resetText = generator.generateFont(parameter);

	}

	public void setWinnerText(int redScore, int blueScore) {
		resetText.setColor(Color.BLACK);

		if (redScore > blueScore) {
			winnerText.setColor(Color.RED);
			winnerPosX = 50;

		} else {
			winnerPosX = 100;
			winnerText.setColor(Color.BLUE);

		}
	}

	public void drawTela(SpriteBatch batch, int redScore, int blueScore) {

		setWinnerText(redScore, blueScore);

		if (redScore > blueScore) {
			winnerText.draw(batch, "JOGADOR VERMELHO GANHOU", winnerPosX, winnerPosY);
			resetText.draw(batch, "PARA REINICIAR\nAPERTE ESPAÇO", resetPosX, resetPosY);
		} else {
			winnerText.draw(batch, "JOGADOR AZUL GANHOU", winnerPosX, winnerPosY);
			resetText.draw(batch, "PARA REINICIAR\nAPERTE ESPAÇO", resetPosX, resetPosY);
		}

	}

	public void dispose() {
		winnerText.dispose();
		resetText.dispose();
	}

}
