package board;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Menu {
	Sprite TelaMenu,CaixaDasOpções,Jogodor_Contra_Jogador,Jogodor_Contra_Maquina;
	Texture ImagemTelaMenu,ImagemCaixaDasOpções,ImagemBotaoJogodor_Contra_Jogador1,ImagemBotaoJogodor_Contra_Maquina2;
	public Menu(){
		
		
		ImagemCaixaDasOpções = new Texture("C:\\Users\\PICHAU\\OneDrive\\Área de Trabalho\\Java\\Boxs-Dots-main\\boxs_dots\\assets\\Tela_Fundo.png");
		CaixaDasOpções  = new Sprite(ImagemCaixaDasOpções);
		
		ImagemBotaoJogodor_Contra_Maquina2 = new Texture("C:\\Users\\PICHAU\\OneDrive\\Área de Trabalho\\Java\\Boxs-Dots-main\\boxs_dots\\assets\\Jogodor_Contra_Maquina.png");
		Jogodor_Contra_Maquina = new Sprite(ImagemBotaoJogodor_Contra_Maquina2);
		
		ImagemBotaoJogodor_Contra_Jogador1 = new Texture("C:\\Users\\PICHAU\\OneDrive\\Área de Trabalho\\Java\\Boxs-Dots-main\\boxs_dots\\assets\\Jogodor_Contra_Jogador.png");
		Jogodor_Contra_Jogador = new Sprite(ImagemBotaoJogodor_Contra_Jogador1);
	}
	public void iniciaMenu(SpriteBatch batch){
		CaixaDasOpções.setScale(0.85f,1.3f);
		CaixaDasOpções.setPosition(-37,90);
		Jogodor_Contra_Jogador.setPosition(30,20);
		Jogodor_Contra_Maquina.setPosition(140,390);
		CaixaDasOpções.draw(batch);
		Jogodor_Contra_Maquina.draw(batch);
		
	}
	public void dispose() {
		Jogodor_Contra_Maquina.getTexture().dispose();
	}
}