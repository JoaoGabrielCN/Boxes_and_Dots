package users;

import java.util.Random;

import com.badlogic.gdx.graphics.OrthographicCamera;

import board.Dots;
import board.Line;

public class Bot extends AbstractPlayer {
	public boolean play(Line[][] columns, Line[][] lines, Dots[][] dots, OrthographicCamera camera, boolean turn) {
		Random random = new Random();

			int tipo = random.nextInt(2);

			if (tipo == 0) {
				int i = random.nextInt(5);
				int j = random.nextInt(6);

				if (lines[i][j].getVisibility() == 0) {
					lines[i][j].setTurn(false);
					lines[i][j].setVisibility(2);
					lines[i][j].exist = true;
					return true;
				}
			} else {
				int i = random.nextInt(6);
				int j = random.nextInt(5);

				if (columns[i][j].getVisibility() == 0) {
					columns[i][j].setTurn(false);
					columns[i][j].setVisibility(2);
					columns[i][j].exist = true;

					return true;
				}
			}

		return false;
	}
}
