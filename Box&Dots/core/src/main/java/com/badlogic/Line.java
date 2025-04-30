package com.badlogic;


import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Line {
    Vector2 pos;
    int visible;
    Boolean align;
  private Texture HorizontallineTexture,verticalLineTexture;
    private Sprite line;
  


    public Line(Vector2 pos, int visable, Boolean align){  
        this.pos = pos;
        this.visible = visable;
        this.align = align;
        this.verticalLineTexture = new Texture("LinhaVertical.png");
          line = new Sprite(verticalLineTexture);
          
       
        this.line.setPosition(pos.x, pos.y);
        if(!align){
          
          this.HorizontallineTexture = new Texture("LinhaHorizontal.png");
        this.line = new Sprite(HorizontallineTexture);
        this.line.setPosition(pos.x, pos.y);
        
        }
    }

    public Line(){
        this.pos = new Vector2(0,0);
        this.visible = 0;
        this.align = false;

    
        
    }

  public void draw(SpriteBatch batch){
    if(!align){
      line.setSize(108, 10);
    }else{
      line.setSize(10, 108);
    }
    line.draw(batch);

  }
  public void dispose() {
    line.getTexture().dispose(); // Dispose of the texture when done
  }

}
