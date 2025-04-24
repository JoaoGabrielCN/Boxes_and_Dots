package Boxs_Dots.source;
import org.lwjgl.util.vector.Vector2f;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;


public class Line {
    Vector2 pos;
    int visible;
    Boolean align;
    ShapeRenderer shape;
    float heigth, width;

    public Line(Vector2 pos, int visable, Boolean align){  
        this.pos = pos;
        this.visible = visable;
        this.align = align;
        this.heigth = 100;
        this.width = 8;

      
        this.shape = new ShapeRenderer();

        if(!align){
          float temp;
          temp = this.heigth;
          this.heigth = this.width;
          this.width = temp;
        
        }
    }

    public Line(){
        this.pos = new Vector2(0,0);
        this.visible = 0;
        this.align = false;

        shape = new ShapeRenderer();
        
    }

  public void draw(){
    shape.begin(ShapeRenderer.ShapeType.FilledRectangle);
    shape.setColor(Color.RED);
    shape.filledRect(pos.x, pos.y, width, heigth);
    shape.end();
  }

}
