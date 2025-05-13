package users;

import com.badlogic.gdx.graphics.OrthographicCamera;

import board.Dots;
import board.Line;

public abstract class AbstractPlayer {
	private int score;

	public int getScore() {
		return score;
	}

	public void incrementScore() {
		score++;
	}

	public abstract boolean play(Line[][] columns, Line[][] lines, Dots[][] dots, OrthographicCamera camera,
			boolean turn);
}
