package com.badlogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Line {
	Vector2 pos;
	public int visible;
	Boolean align;
	private Texture horizontalTexture, verticalTexture;
	private Sprite line;

	public Line(Vector2 pos, Boolean align) {
		this.pos = pos;
		this.align = align;
		visible = 0;
		
		intializeLines();
	}


	public void draw(SpriteBatch batch) {
		line.draw(batch);
	}

	public void dispose() {
		line.getTexture().dispose(); 
	}

	private void intializeLines() {
		verticalTexture = new Texture("LinhaVertical.png");
		horizontalTexture = new Texture("LinhaHorizontal.png");

		if (!align) {
			line = new Sprite(horizontalTexture);
		}else {
			line = new Sprite(verticalTexture);
		}
		
		line.setPosition(pos.x, pos.y);
	}
}
