package Boxs_Dots.source;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.*;

public class Board {
    ShapeRenderer dots;
    ArrayList<Line> verticalLines, horizontalLines;

    final static int CIRCLE_RADIUS = 14;

    public Board() {
        verticalLines = new ArrayList<>();
        horizontalLines = new ArrayList<>();

        dots = new ShapeRenderer();
    }

    public void draw() {
        dots.begin(ShapeRenderer.ShapeType.FilledCircle);
        dots.setColor(Color.WHITE);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dots.filledCircle(i * 100 + 100, j * 100 + 50, CIRCLE_RADIUS);
                if (j < 5) {
                    Line line = new Line(new Vector2(i * 100 + 95, j * 100 + 43), 0, true);
                    verticalLines.add(line);

                }
                if (i < 5) {
                    Line line = new Line(new Vector2(i * 100 + 95, j * 100 + 43), 0, false);
                    horizontalLines.add(line);
                }
            }
        }

        for (Line line : horizontalLines) {
            line.draw();
        }

        for (Line line : verticalLines) {
            line.draw();
        }

        dots.end();
    }

    

    public void dispose() {
        dots.dispose();
        for (Line line : horizontalLines) {
            line.shape.dispose();
        }

        for (Line line : verticalLines) {
            line.shape.dispose();
        }
    }

}