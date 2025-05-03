package com.badlogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Square {
	private Vector2 position;
	private Sprite sprite;
	private Texture squareTexture;
	public boolean exists=false;
	
	Square(Vector2 position) {
		this.position = position;
		squareTexture = new Texture("Quadrado.png");
		sprite = new Sprite(squareTexture);
		sprite.setPosition(position.x, position.y);
	}

	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	public void TestaQuadrado(Line[][] verticalLines, Line[][] horizontalLines,boolean turn) {
		if(exists == false) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (verticalLines[i][j].visible == 2 && horizontalLines[i][j].visible == 2
						&& verticalLines[i+1][j].visible == 2 && horizontalLines[i][j+1].visible == 2) {
					System.out.println("quadrado" + i + j + " existe");
					if(turn = true) {
						System.out.println("Quadrado player1");
					}else {
						System.out.println("Quadrado player2");

					}
					exists = true;
				}else {
					exists = false;
				}
				
			}
		}
		}
	}

	public void dispose() {
		sprite.getTexture().dispose(); // Dispose of the texture when done
	}
}
