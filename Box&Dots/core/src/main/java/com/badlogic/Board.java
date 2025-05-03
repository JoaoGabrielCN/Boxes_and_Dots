package com.badlogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Board {
	Dots[][] dots;
	Line[][] columns, lines;
	Square[][] squares;
	OrthographicCamera camera;
	Boolean turn=true;//se o turn = true,vez player1 se não player2

	public Board() {
		dots = new Dots[6][6];
		lines = new Line[5][6];
		columns = new Line[6][5];
		squares = new Square[5][5];

		intializeBoard();

		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);

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
				if(column.clicked(camera,turn) == true) {
					turn = !turn;
					System.out.println("trocou!");
				}
					
			}

		}

		for (Line[] lines2 : lines) {
			for (Line line : lines2) {
				line.draw(batch);
				
				if(line.clicked(camera,turn) == true) {
					turn = !turn;
					System.out.println("trocou!");
				}

			}
		}

		for (Dots[] dots2 : dots) {
			for (Dots dots : dots2) {
				dots.draw(batch);
			}
		}
		for (Square[] squares2 : squares) {
			for (Square square : squares2) {
				square.TestaQuadrado(columns, lines,turn);

			}
		}
		camera.update();

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

	}

	private void intializeBoard() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				dots[i][j] = new Dots(i * 100 + 95, j * 100 + 45);

			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				columns[i][j] = new Line(new Vector2(i * 100 + 105, j * 100 + 50), true);
				lines[j][i] = new Line(new Vector2(j * 100 + 105, i * 100 + 50), false);
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				squares[i][j] = new Square(new Vector2(i * 100 + 110, j * 100 + 57));
			}

		}

	}
}
