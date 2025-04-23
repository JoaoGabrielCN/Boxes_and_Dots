package Boxs_Dots.source;
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

    public Line(Vector2 pos, int visable, Boolean align, float heigth, float width){  
        this.pos = pos;
        this.visible = visable;
        this.align = align;
        this.heigth = heigth;
        this.width = width;
        this.shape = new ShapeRenderer();
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
