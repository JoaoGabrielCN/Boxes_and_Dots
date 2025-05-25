package users;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;

import board.Dots;
import board.Line;

public abstract class AbstractPlayer {
	private int score;
	protected Sound clickSound;
	
	public AbstractPlayer() {
		clickSound = Gdx.audio.newSound(Gdx.files.internal("clickSound.mp3"));
	}
	public int getScore() {
		return score;
	}

	public void incrementScore() {
		score++;
	}

	public abstract boolean play(Line[][] columns, Line[][] lines, Dots[][] dots, OrthographicCamera camera,
			boolean turn);
	
	public void resetScore() {
        score = 0;
    }
}
