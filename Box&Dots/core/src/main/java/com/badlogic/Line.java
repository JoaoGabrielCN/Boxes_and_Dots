package com.badlogic;

import java.util.Iterator;

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
	private boolean exist;
	Vector3 touchPoint = new Vector3();
	Boolean turn = true;// se o turn = true,linha do player1 se não player2

	public Line(Vector2 pos, Boolean align) {
		this.pos = pos;
		this.align = align;
		visible = 0;
		exist = false;

		intializeLines();
	}

	public void draw(SpriteBatch batch) {
		switch (visible) {
		case 0:
			line.setColor(0f, 0f, 0f, 1f);
			line.draw(batch);
			break;
		case 1:
			if (turn) {
				line.setColor(0.1f, 0.1f, 1f, 1f);
			} else {

				line.setColor(1f, 0.1f, 0.1f, 1f);
			}

			line.draw(batch);
			break;
		case 2:
			line.draw(batch);
			break;

		}

	}

	public void dispose() {
		line.getTexture().dispose();
	}

	private void intializeLines() {
		verticalTexture = new Texture("LinhaVertical1.png");
		horizontalTexture = new Texture("LinhaHorizontal1.png");

		if (!align) {
			line = new Sprite(horizontalTexture);
		} else {
			line = new Sprite(verticalTexture);
		}

		line.setPosition(pos.x, pos.y);
	}

	public boolean MouseOver(OrthographicCamera camera, boolean turn, Dots dot1, Dots dot2) {
	    Vector3 mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
	    camera.unproject(mousePos);

	    // Bloqueia clique se o mouse estiver sobre qualquer um dos dots ligados à linha
	    if (dot1.MouseOver(camera) || dot2.MouseOver(camera)) {
	        setVisibility(0); // reseta cor se quiser
	        return false;
	    }

	    if (!exist && line.getBoundingRectangle().contains(mousePos.x, mousePos.y)) {
	        setVisibility(1);
	        this.turn = turn;
	        return clicked(camera, turn);
	    } else {
	        setVisibility(0);
	    }

	    return false;
	}


	public boolean clicked(OrthographicCamera camera, boolean turn) {

		if (Gdx.input.justTouched()) {
			Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);

			if (line.getBoundingRectangle().contains(touchPos.x, touchPos.y)) {
				System.out.println("Sprite foi clicado!");
				setVisibility(2);

				exist = true;
				return true;
			}
		}
		return false;

	}

	public void setVisibility(int num) {
		visible = num;
	}
}