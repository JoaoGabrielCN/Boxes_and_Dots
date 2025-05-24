package board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import users.AbstractPlayer;

public class Square {

	private Sprite sprite;
	private Texture squareTexture;
	private boolean exists;
	private boolean turn;
	private int i, j;
	private Sound squareSound;

	Square(int x, int y, int i, int j) {
		exists = false;
		this.i = i;
		this.j = j;
		squareTexture = new Texture("Quadrado1.png");
		sprite = new Sprite(squareTexture);
		sprite.setSize(100, 100);
		sprite.setPosition(x, y);
		squareSound = Gdx.audio.newSound(Gdx.files.internal("squareSound.mp3"));

	}

	public void draw(SpriteBatch batch) {
		if (exists) {

			sprite.draw(batch);
		}
	}

	public boolean checkSquare(Line[][] verticalLines, Line[][] horizontalLines, boolean turn, AbstractPlayer player) {
		this.turn = turn;

		if (!exists) {

			if (verticalLines[i][j].visible == 2 && horizontalLines[i][j].visible == 2 && verticalLines[i + 1][j].visible == 2 && horizontalLines[i][j + 1].visible == 2){
				exists = true;
				setColor();

				player.incrementScore();
				squareSound.play();
				return true;
				
			}
		}
		return false;

	}

	private void setColor() {
		if (turn) {

			sprite.setColor(0.4f, 0.4f, 1f, 1f);
		} else {
			sprite.setColor(1f, 0.4f, 0.4f, 1f);
		}
	}


	public void dispose() {
		sprite.getTexture().dispose();
	}
}