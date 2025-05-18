package main;

import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import board.Board;
import board.Menu;
public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;

	Board board;
	Menu menu;
	@Override
	public void create() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		menu = new Menu();
		board = new Board();

	}

	@Override
	public void render() {
		ScreenUtils.clear(0.6f, 0.7f, 0.6f, 1);

		camera.update(); 
		batch.setProjectionMatrix(camera.combined); 
		

		board.update();
		batch.begin();
		board.draw(batch);
		menu.iniciaMenu(batch);
		batch.end();
		
	}

	@Override
	public void dispose() {
		menu.dispose();
		batch.dispose();
		board.dispose();

	}

	@Override
	public void resize(int width, int height) {

		camera.setToOrtho(false, width, height);

	}
}
