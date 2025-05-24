package users;

import com.badlogic.gdx.graphics.OrthographicCamera;

import board.Dots;
import board.Line;

public class Player extends AbstractPlayer {
	public boolean play(Line[][] columns, Line[][] lines, Dots[][] dots, OrthographicCamera camera, boolean turn) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				if (columns[i][j].mouseOver(camera, turn, dots)) {
					columns[i][j].setVisibility(2);
					clickSound.play();
					return true;
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if (lines[i][j].mouseOver(camera, turn, dots)) {
					lines[i][j].setVisibility(2);
					clickSound.play();
					return true;
				}
			}
		}

		return false;
	}
}
