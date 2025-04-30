package com.badlogic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Board {
    ArrayList<dots> pontos;
    private Texture dotsImage;
    ArrayList<Line> verticalLines, horizontalLines;
    public Board() {
        pontos = new ArrayList<>();
       
        dotsImage = new Texture("Bola.png");

        verticalLines = new ArrayList<>();
        horizontalLines = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
               pontos.add(new dots(dotsImage,i * 100 + 95, j * 100 + 45));
            }
           }
         for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j < 5) {
                    verticalLines.add(new Line(new Vector2(i * 100 + 105, j * 100 + 50), 0, true));
                }
                if (i < 5) {
                    horizontalLines.add(new Line(new Vector2(i * 100 + 105, j * 100 + 50), 0, false) );
                }
            }
        }
       
    }
    public void draw(SpriteBatch batch) {
        
        for (Line line : horizontalLines) {
            //line.shape.setProjectionMatrix(camera.combined);
            line.draw(batch);
         }
    
         for (Line line : verticalLines) {
           // line.shape.setProjectionMatrix(camera.combined);
            line.draw(batch);
         }
         for (dots ponto : pontos) {
            ponto.draw(batch); // Draw each dot in the array
        }
        
    }
    public void dispose() {
        for (dots ponto : pontos) {
            ponto.dispose(); // Dispose of each dot in the array
        }
        for (Line line : horizontalLines) {
            line.dispose();
        }
        for (Line line : verticalLines) {
            line.dispose();
        }
        dotsImage.dispose(); // Dispose of the texture when done
    }
}
