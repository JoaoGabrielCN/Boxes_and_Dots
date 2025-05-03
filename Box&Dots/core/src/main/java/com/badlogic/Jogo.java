package com.badlogic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class Jogo extends ApplicationAdapter {
    private SpriteBatch batch;
    
 
    Board board;

    @Override
    public void create() {
        batch = new SpriteBatch();
       
        board = new Board();
        
    }

    @Override
    public void render() {
      ScreenUtils.clear(0.5f, 0.7f, 1f, 1);

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
}
