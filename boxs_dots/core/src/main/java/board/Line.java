package board;

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
	public boolean exist;
	Vector3 touchPoint = new Vector3();
	Boolean turn = true;

	public Line(Vector2 pos, Boolean align) {
		this.pos = pos;
		this.align = align;
		visible = 0;
		exist = false;

		intializeLines();
	}

	private void setColor() {

		if (visible == 2 || visible == 1) {
			if (turn) {
				line.setColor(0.1f, 0.1f, 1f, 1f);
			} else {

				line.setColor(1f, 0.1f, 0.1f, 1f);
			}
		} else {
			line.setColor(0f, 0f, 0f, 1f);
		}
	}

	public void draw(SpriteBatch batch) {

		setColor();
		line.draw(batch);

	}

	public void dispose() {
		line.getTexture().dispose();
	}

	private void intializeLines() {
		verticalTexture = new Texture("LinhaVertical1.png");
		horizontalTexture = new Texture("LinhaHorizontal1.png");

		if (align) {
			line = new Sprite(verticalTexture);
		} else {
			line = new Sprite(horizontalTexture);
		}

		line.setPosition(pos.x, pos.y);
	}

	public boolean mouseOver(OrthographicCamera camera, boolean turn, Dots[][] Dots) {

		Vector3 mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		
		camera.unproject(mousePos);

		int i = (int) getMouseIndex(mousePos).x;
		int j = (int) getMouseIndex(mousePos).y;

		boolean mouseOverDot = Dots[i][j].getSprite().getBoundingRectangle().contains(mousePos.x, mousePos.y);
		boolean mouseOverLine = line.getBoundingRectangle().contains(mousePos.x, mousePos.y);

		if (!mouseOverDot && !exist) {

			if (mouseOverLine) {
				setVisibility(1);
				this.turn = turn;

				return clicked(camera, turn, mousePos);

			} else {
				setVisibility(0);
			}

		}

		return false;
	}

	private Vector3 getMouseIndex(Vector3 mousePos) {

		int i = ((int) mousePos.x - 35) / 100;
		int j = ((int) mousePos.y - 35) / 100;

		if (i < 0)
			i = 0;

		if (i > 5)
			i = 5;

		if (j > 5)
			j = 5;

		if (j < 0)
			j = 0;

		return new Vector3(i, j, 0);
	}

	public boolean clicked(OrthographicCamera camera, boolean turn, Vector3 touchPos) {

		if (Gdx.input.justTouched()) {

			if (line.getBoundingRectangle().contains(touchPos.x, touchPos.y)) {
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

	public int getVisibility() {
		return visible;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

}