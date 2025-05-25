package telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class GameOver {
private BitmapFont winner, reset;
private int resetPosX, resetPosY, winnerPosX, winnerPosY;

public GameOver() {
FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("CutePixel.ttf"));
FreeTypeFontParameter parameter = new FreeTypeFontParameter();
parameter.size = 50;

winnerPosX = 50;
winnerPosY = 450;

resetPosX=150;
resetPosY = 250;

winner = new BitmapFont();
winner = generator.generateFont(parameter);

reset = new BitmapFont();
reset = generator.generateFont(parameter);


}

public void whoIsWinner(int redScore, int blueScore) {
if(redScore>blueScore) {
winner.setColor(Color.RED);
reset.setColor(Color.RED);
winnerPosX=50;

}else {
	winnerPosX=100;
winner.setColor(Color.BLUE);
reset.setColor(Color.BLUE);

}
}

public void drawTela(SpriteBatch batch, int redScore, int blueScore) {

whoIsWinner(redScore, blueScore);

if(redScore>blueScore) {
winner.draw(batch, "JOGADOR VERMELHO GANHOU", winnerPosX, winnerPosY);
reset.draw(batch,"RESET",resetPosX, resetPosY);
}else {
winner.draw(batch, "JOGADOR AZUL GANHOU", winnerPosX, winnerPosY);
reset.draw(batch,"PARA REINICIAR \n APERTE ESPAÇO",resetPosX, resetPosY);
}



}



}
