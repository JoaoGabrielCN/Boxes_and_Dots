package board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Board {
	Dots[][] dots;
	Line[][] columns, lines;
	Square[][] squares;
	OrthographicCamera camera;
	Placar placarAzul;
	Placar placarVermelho;
	int pontosRed;
	int pontosBlue;
	
	Boolean turn=true;//se o turn = true,vez player1 se não player2

	public Board() {
		dots = new Dots[6][6];
		lines = new Line[5][6];
		columns = new Line[6][5];
		squares = new Square[5][5];
		placarAzul = new Placar(0);
		placarVermelho = new Placar(1);
		pontosRed =0;
		pontosBlue=0;

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
		placarAzul.draw(batch, Square.getPointsBlue());
		placarVermelho.draw(batch, Square.getPointsRed());
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
		
		placarAzul.dispose();
		placarVermelho.dispose();
		
		

	}

	private void intializeBoard() {

		 for (int i = 0; i < 6; i++) {
		        for (int j = 0; j < 6; j++) {
		            dots[i][j] = new Dots(i * 100 + 35, j * 100 + 35);
		        }
		    }

		
		    for (int i = 0; i < 6; i++) {
		        for (int j = 0; j < 5; j++) {
		            columns[i][j] = new Line(new Vector2(i * 100 + 40, j * 100 + 35 + 15), true); 
		        }
		    }

		    
		    for (int i = 0; i < 5; i++) {
		        for (int j = 0; j < 6; j++) {
		            lines[i][j] = new Line(new Vector2(i * 100 + 35 + 15, j * 100 + 40), false); 
		        }
		    }

		    
		    for (int i = 0; i < 5; i++) {
		        for (int j = 0; j < 5; j++) {
		            squares[i][j] = new Square(i * 100 + 50, j * 100 + 50, i, j);
		        }
		    }
		    
		    placarAzul.render();
		    placarVermelho.render();

	}
	
	
	public void update(){
		for (Square[] squares2 : squares) {
			for (Square square : squares2) {
				square.checkSquare(columns, lines, turn);
			}
		}
		

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				if(columns[i][j].MouseOver(camera,turn,dots)) {
					turn = !turn;
					
				}
					
			}

		}

		  for (int i = 0; i < 5; i++) {
		        for (int j = 0; j < 6; j++) {
				
				if(lines[i][j].MouseOver(camera,turn,dots)) {
					turn = !turn;
					
				}

			}
		}
		  
		  trocaTurno(); 
	}
		public void trocaTurno(){
			if(pontosRed<Square.getPointsRed() || pontosBlue<Square.getPointsBlue() ) {
				turn=!turn;
				pontosRed=Square.getPointsRed();
				pontosBlue=Square.getPointsBlue();
				}
			
		}
	}
	
	
