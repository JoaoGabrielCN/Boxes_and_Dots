package com.badlogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Square {
	
	private Sprite sprite;
	private Texture squareTexture;
	public boolean exists;
	 boolean turn;
	private int i, j, x, y;

	Square(int x, int y, int i , int j) {
		exists = false;
		this.x = x;
		this.y = y;	
		this.i = i;
		this.j = j;
		squareTexture = new Texture("Quadrado1.png");
		sprite = new Sprite(squareTexture);
		sprite.setSize(100, 100);
		sprite.setPosition(x, y);
	
	}

	public void draw(SpriteBatch batch) {
		if(turn == true) {
			sprite.setColor(1f, 0.4f, 0.4f, 1f);
			sprite.draw(batch);
		}else {
			sprite.setColor(0.4f, 0.4f, 1f, 1f);
			
			sprite.draw(batch);
		}
		
	}

	public void TestaQuadrado(Line[][] verticalLines, Line[][] horizontalLines, boolean turn) {

		if (!exists) {
			if (verticalLines[i][j].visible == 2 && horizontalLines[i][j].visible == 2
					&& verticalLines[i + 1][j].visible == 2 && horizontalLines[i][j + 1].visible == 2) {
				exists = true;
				this.turn = turn;
			} else {
				exists = false;
			}

		}
	}

	public void dispose() {
		sprite.getTexture().dispose(); 
	}
}