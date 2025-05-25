package main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import board.Board;
import telas.GameOverScreen;
import telas.Menu;
import telas.ScreensManager;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private ScreensManager screensManager;

	@Override
	public void create() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
	
		resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		screensManager = new ScreensManager(batch, camera);

	}

	@Override
	public void render() {
		ScreenUtils.clear(0.6f, 0.7f, 0.6f, 1);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		screensManager.updateScreens();
		batch.end();

	}

	@Override
	public void dispose() {
		screensManager.dispose();
		batch.dispose();

	}

	@Override
	public void resize(int width, int height) {

		camera.setToOrtho(false, width, height);

	}
}
