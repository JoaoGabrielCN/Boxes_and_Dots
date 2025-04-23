package Boxs_Dots.source;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer; 
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.*;

public class Board {
    Line verticalLines[][], horizontalLines[][];
    ShapeRenderer dots;

    public Board() {
        verticalLines = new Line[6][6];
        horizontalLines = new Line[6][6];

        dots = new ShapeRenderer();
    }

    public void draw() {
       try{ dots.begin(ShapeRenderer.ShapeType.FilledCircle);
        dots.setColor(Color.WHITE); 

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
              
                
                dots.filledCircle(i * 100 + 100, j * 100 + 50, 13);
                verticalLines[i][j] = new Line(new Vector2(i * 100 + 50, j * 100), 0, true, 10, 100);
                horizontalLines[i][j] = new Line(new Vector2(i * 100, j * 100 + 50), 0, false, 100, 10);
                verticalLines[i][j].draw();
                horizontalLines[i][j].draw();
            }
        }

        dots.end();}
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void dispose() {
        dots.dispose();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                verticalLines[i][j].shape.dispose();
                horizontalLines[i][j].shape.dispose();
            }

            
            }
        }
    }

