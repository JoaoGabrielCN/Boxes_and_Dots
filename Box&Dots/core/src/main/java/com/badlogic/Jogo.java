package com.badlogic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class Jogo extends ApplicationAdapter {
    private SpriteBatch batch;
    private OrthographicCamera camera;
 
    Board board;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();

        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        board = new Board();
        
    }

    @Override
    public void render() {
      ScreenUtils.clear(0.5f, 0.7f, 1f, 1);
      
      camera.update(); // Atualiza transformações da câmera
      batch.setProjectionMatrix(camera.combined); // Aplica

      batch.begin();
      if (board != null) {
          board.draw(batch);
      }
      batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        board.dispose();
    
       
    }
    
    @Override
    public void resize(int width, int height) {
        
        camera.setToOrtho(false, width, height);
     
}}
