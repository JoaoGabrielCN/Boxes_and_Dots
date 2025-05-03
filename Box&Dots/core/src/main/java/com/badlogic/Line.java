package com.badlogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Line {
	Vector2 pos;
	public int visible;
	Boolean align;
	private Texture horizontalTexture, verticalTexture;
	private Sprite line;
	private boolean tagTeam;
	Vector3 touchPoint = new Vector3();
	Boolean turn = true;// se o turn = true,linha do player1 se não player2

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
		} else {
			line = new Sprite(verticalTexture);
		}

		line.setPosition(pos.x, pos.y);
	}

	public boolean clicked(OrthographicCamera camera, boolean turn) {
		if (Gdx.input.justTouched()) {
			Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);

			if (line.getBoundingRectangle().contains(touchPos.x, touchPos.y)) {
				System.out.println("Sprite foi clicado!");
				visible = 2;
				this.turn = turn;
				return true;
			}
		}
		return false;
	}
	
	public void setVisibility(int num){
		visible = num;
	}
}