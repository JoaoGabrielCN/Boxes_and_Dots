package board;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Dots {
	private Texture dotsImage;
	private Sprite Dots;


	Dots(int x, int y) {
		dotsImage = new Texture("Bola.png");
		Dots = new Sprite(dotsImage);
		Dots.setPosition(x, y);
	}

	public void draw(SpriteBatch batch) {

		Dots.setSize(30, 30);
		Dots.draw(batch);
	
	}

	public void dispose() {

		Dots.getTexture().dispose(); // Dispose of the texture when done
	}

	public Sprite getSprite() {
		return Dots;
	}
}
