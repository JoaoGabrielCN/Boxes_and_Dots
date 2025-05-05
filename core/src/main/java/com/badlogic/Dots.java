package com.badlogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Dots {
	private Texture dotsImage;
	private Sprite Dots;

	private int i, j;

	Dots(int x, int y, int i, int j) {
		dotsImage = new Texture("Bola.png");
		Dots = new Sprite(dotsImage);
		Dots.setPosition(x, y);
		this.i = i;
		this.j = j;
	}

	public void draw(SpriteBatch batch) {

		Dots.setSize(30, 30);
		Dots.draw(batch);
	
	}

	public void dispose() {

		Dots.getTexture().dispose(); // Dispose of the texture when done
	}

	public Sprite getSprite() {
		return Dots;
	}

	public boolean MouseOver(OrthographicCamera camera) {
		Vector3 mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(mousePos);

		if (Dots.getBoundingRectangle().contains(mousePos.x, mousePos.y)) {
			System.out.println("O mouse me molestou");

			return true;
		} else {

		}

		return false;

	}
}
