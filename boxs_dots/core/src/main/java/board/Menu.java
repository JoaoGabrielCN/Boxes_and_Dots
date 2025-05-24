package board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Menu {
	private Texture textureMenuBackground,textureJogador_Contra_Jogador,textureJogodor_Contra_Maquina;
	private Sprite menuBackground,jogador_Contra_Jogador,jogodor_Contra_Maquina;
	private Boolean gameBegin=false;
	public Menu(){
		
		textureMenuBackground = new Texture("Tela_Fundo.png");
		menuBackground = new Sprite(textureMenuBackground);
		
		textureJogador_Contra_Jogador = new Texture("Jogador_Contra_Jogador.png");
		jogador_Contra_Jogador = new Sprite(textureJogador_Contra_Jogador);
		
		textureJogodor_Contra_Maquina = new Texture("Jogador_Contra_Maquina.png");
		jogodor_Contra_Maquina = new Sprite(textureJogodor_Contra_Maquina);
	}
	public void iniciaMenu(SpriteBatch batch){
		menuBackground.setSize(600,700);
		menuBackground.setPosition(0,0);
		
		jogador_Contra_Jogador.setPosition(140,390);
		jogodor_Contra_Maquina.setPosition(140,190);

		menuBackground.draw(batch);
		jogador_Contra_Jogador.draw(batch);
		jogodor_Contra_Maquina.draw(batch);
	}
	public int buttonClicked(OrthographicCamera camera) {
		
		Vector3 mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(mousePos);
		if (Gdx.input.justTouched()) {
	
			if(jogador_Contra_Jogador.getBoundingRectangle().contains(mousePos.x,mousePos.y) ) {
			System.out.println("aaaa");
			return 1;
			
		
			}else if(jogodor_Contra_Maquina.getBoundingRectangle().contains(mousePos.x,mousePos.y) ) {
			System.out.println("lol");
			return 2;
		}
		}
		return 0;
	}
	public void dispose() {
		menuBackground.getTexture().dispose();
		jogador_Contra_Jogador.getTexture().dispose();
		jogodor_Contra_Maquina.getTexture().dispose();
	}
	public void setBeginGame(Boolean gameBegin) {
		this.gameBegin = gameBegin;
	}
	public Boolean getBeginGame() {
		return gameBegin;
	}
}