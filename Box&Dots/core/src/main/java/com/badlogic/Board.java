package com.badlogic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Board {
	Dots[][] dots;
	Line[][] columns, lines;
	Square[][] squares;

	public Board() {
		dots = new Dots[6][6];
		lines = new Line[5][6];
		columns = new Line[6][5];
		squares = new Square[5][5];

		intializeBoard();
		columns[4][4].visible = 2;
		lines[4][4].visible = 2;
		columns[5][4].visible = 2;
		lines[4][5].visible = 2;
		
		columns[4][4].visible = 2;
		lines[4][4].visible = 2;
		columns[5][4].visible = 2;
		lines[4][5].visible = 2;
		
		
		
		squares[4][4].TestaQuadrado(columns, lines);
	}

	public void draw(SpriteBatch batch) {

//		for (Square[] squares2 : squares) {
//			for (Square square : squares2) {
//				square.draw(batch);
//			}
//		}
//		
//		for (Line[] columns2 : columns) {
//			for (Line column : columns2) {
//				column.draw(batch);
//			}
//		}
//
//		for (Line[] lines2 : lines) {
//			for (Line line : lines2) {
//				line.draw(batch);
//				
//			}
//		}
//
//		for (Dots[] dots2 : dots) {
//			for (Dots dots : dots2) {
//				dots.draw(batch);
//			}
//		}

		columns[4][4].draw(batch);
		lines[4][4].draw(batch);
		columns[5][4].draw(batch);
		lines[4][5].draw(batch);

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
				;
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
				;
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
