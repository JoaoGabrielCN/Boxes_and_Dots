package board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import users.AbstractPlayer;
import users.Bot;
import users.Player;

public class Board {
	Dots[][] dots;
	Line[][] columns, lines;
	Square[][] squares;
	OrthographicCamera camera;
	Placar placarAzul;
	Placar placarVermelho;
	int pontosRed;
	int pontosBlue;
	boolean jogada;
	public AbstractPlayer player1, player2;
	Boolean turn = true;

	public Board(OrthographicCamera camera) {
		dots = new Dots[6][6];
		lines = new Line[5][6];
		columns = new Line[6][5];
		squares = new Square[5][5];
		placarAzul = new Placar(true);
		placarVermelho = new Placar(false);
		pontosRed = 0;
		pontosBlue = 0;
		player1 = new Player();
		this.camera = camera;

		intializeBoardPositions();
	}

	public void setControle(int controle) {
		if (controle == 2) {
			player2 = new Bot();
		} else {
			player2 = new Player();
		}

	}

	public void draw(SpriteBatch batch) {

		for (Square[] squares2 : squares) {
			for (Square square : squares2) {
				square.draw(batch);
			}
		}
		for (Line[] columns2 : columns) {
			for (Line column : columns2) {
				column.draw(batch);
			}
		}
		for (Line[] lines2 : lines) {
			for (Line line : lines2) {
				line.draw(batch);
			}
		}
		for (Dots[] dots2 : dots) {
			for (Dots dots : dots2) {
				dots.draw(batch);
			}
		}

		placarAzul.draw(batch, player1.getScore());
		placarVermelho.draw(batch, player2.getScore());
	}

	public void dispose() {

		for (Dots[] dots2 : dots) {
			for (Dots dots : dots2) {
				dots.dispose();
			}
		}
		for (Line[] columns2 : columns) {
			for (Line column : columns2) {
				column.dispose();
			}
		}
		for (Line[] lines2 : lines) {
			for (Line line : lines2) {
				line.dispose();

			}
		}
		for (Square[] squares2 : squares) {
			for (Square square : squares2) {
				square.dispose();
			}
		}

		placarAzul.dispose();
		placarVermelho.dispose();
	}

	private void intializeBoardPositions() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				dots[i][j] = new Dots(i * 100 + 35, j * 100 + 35);
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				columns[i][j] = new Line(new Vector2(i * 100 + 40, j * 100 + 35 + 15), true);
				lines[j][i] = new Line(new Vector2(j * 100 + 35 + 15, i * 100 + 40), false);
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				squares[i][j] = new Square(i * 100 + 50, j * 100 + 50, i, j);
			}
		}
	}

	public void update() {

		camera.update();

		updateTurn(player1, player2);

	}

	boolean checkBoard() {
		for (Square[] squares2 : squares) {
			for (Square square : squares2) {
				if (turn) {
					if (square.checkSquare(columns, lines, turn, player1)) {
						return true;
					}
				} else {
					if (square.checkSquare(columns, lines, turn, player2)) {
						return true;
					}

				}
			}
		}

		return false;
	}

	void updateTurn(AbstractPlayer p1, AbstractPlayer p2) {

		boolean fechouQuad = false, jogou = false;

		if (turn) {
			if (p1.play(columns, lines, dots, camera, turn)) {

				jogou = true;

			}

		} else {

			if (p2.play(columns, lines, dots, camera, turn)) {
				jogou = true;

			}
		}

		fechouQuad = checkBoard();

		if (jogou && !fechouQuad) {
			turn = !turn;
		}
	}

	public boolean resetGame() {
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {

			for (Square[] squares2 : squares) {
				for (Square square : squares2) {
					square.resetSquare();
				}
			}

			for (Line[] columns2 : columns) {
				for (Line column : columns2) {
					column.resetLine();
				}
			}

			for (Line[] lines2 : lines) {
				for (Line line : lines2) {
					line.resetLine();
				}
			}

			player1.resetScore();
			player2.resetScore();

			return true;
		} else {
			return false;
		}
	}

	public boolean gameOver() {
		if (player1.getScore() + player2.getScore() == 25) {
			return true;
		} else {
			return false;
		}
	}
}
