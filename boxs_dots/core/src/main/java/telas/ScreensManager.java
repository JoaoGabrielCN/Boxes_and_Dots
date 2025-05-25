package telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import board.Board;

public class ScreensManager {
	private Board board;
	private Menu menu;
	private GameOverScreen gameOverScreen;
	private SpriteBatch batch;
	OrthographicCamera camera;
	private float timer = 0;
	private Sound music;

	public ScreensManager(SpriteBatch batch, OrthographicCamera camera) {
		music = Gdx.audio.newSound(Gdx.files.internal("music.mp3"));
		this.batch = batch;
		menu = new Menu();
		gameOverScreen = new GameOverScreen();
		board = new Board(camera);
		this.camera = camera;
		
		music.setVolume(music.loop(), 0.02f);
	}

	public void updateScreens() {
		
				
		if (!menu.getBeginGame()) {
			menu.drawMenu(batch);

			checkClick();

		} else {
			timer += Gdx.graphics.getDeltaTime();
			if (timer > 0.05) {
				board.update();

				checkGameOver();
			}

		}
	}

	public void dispose() {
		menu.dispose();
		board.dispose();
		gameOverScreen.dispose();
	}

	private void checkClick() {
		if (menu.testButtonClicked(camera) == 1) {
			board.setControle(1);
			menu.setBeginGame(true);

		} else if (menu.testButtonClicked(camera) == 2) {
			board.setControle(2);
			menu.setBeginGame(true);
		}
	}

	private void checkGameOver() {
		if (!board.gameOver()) {
			board.draw(batch);

		} else {
			gameOverScreen.drawTela(batch, board.player2.getScore(), board.player1.getScore());
			if (board.resetGame()) {
				menu.setBeginGame(false);
			}

		}
	}
}
