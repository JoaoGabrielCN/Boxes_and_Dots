package main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import board.Board;
import telas.GameOver;
import telas.Menu;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private float timer = 0;
	Board board;
	Menu menu;
	GameOver gameOver;

	@Override
	public void create() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
	
		resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		board = new Board(camera);
		menu = new Menu();
		gameOver = new GameOver();

	}

	@Override
	public void render() {
		ScreenUtils.clear(0.6f, 0.7f, 0.6f, 1);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		if (!menu.getBeginGame()) {
		menu.iniciaMenu(batch);
		}
		if (!menu.getBeginGame()) {
		if (menu.buttonClicked(camera) == 1) {
			board.setControle(1);
			menu.setBeginGame(true);

		} else if (menu.buttonClicked(camera) == 2) {
			board.setControle(2);
			menu.setBeginGame(true);
		}
		}
		if (menu.getBeginGame()) {
			timer += Gdx.graphics.getDeltaTime();
			if (timer > 0.05) {
			board.update();
			if(board.gameOver()==false) {
		        board.draw(batch);

		        }else {
		            gameOver.drawTela(batch, board.player2.getScore(),board.player1.getScore());
		            board.resetGame();
		        }
			}
			
		}
		batch.end();

	}

	@Override
	public void dispose() {
		menu.dispose();
		batch.dispose();
		if (menu.getBeginGame()) {
		board.dispose();}

	}

	@Override
	public void resize(int width, int height) {

		camera.setToOrtho(false, width, height);

	}
}
