package com.badlogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class dots {
    private Texture dotsImage;
    private Sprite Dots;
    private int x, y;
    dots(Texture dotsImage,int x, int y) {
        this.dotsImage = dotsImage;
        Dots = new Sprite(dotsImage);
        Dots.setPosition(x, y);
    }
    public void draw(SpriteBatch batch) {
      
        Dots.setSize(30, 30); // Set the size of the dots sprite
        Dots.draw(batch);
        // Logic to draw the dots on the screen using the dotsImage texture
        // This would typically involve using a SpriteBatch to render the texture at the specified (x, y) coordinates
    }
    public void dispose() {
  
        Dots.getTexture().dispose(); // Dispose of the texture when done
    }
}
