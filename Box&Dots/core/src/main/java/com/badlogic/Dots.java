package com.badlogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Dots {
    private Texture dotsImage;
    private Sprite Dots;
    private int x, y;
    

    Dots(int x, int y) {
    	this.x = x;
    	this.y = y;
    	
        dotsImage = new Texture("Bola.png"); 
        Dots = new Sprite(dotsImage);
        Dots.setPosition(this.x, this.y);

    }

    public void draw(SpriteBatch batch) {

        Dots.setSize(30, 30); 
        Dots.draw(batch);
        
    }

    public void dispose() {

        Dots.getTexture().dispose();
    }
}
