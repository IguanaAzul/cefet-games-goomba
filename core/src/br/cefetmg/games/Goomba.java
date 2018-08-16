/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


/**
 *
 * @author aluno
 */
public class Goomba {
    private Texture spriteSheet;
    private final TextureRegion[][] quadrosDaAnimacao;
    private final Animation andarParaFrente, andarParaTras, andarParaDireita, andarParaEsquerda;
     private Animation animacaoAtual;
    private float tempoDaAnimacao;
    private Vector2 position;
    Goomba(Texture textura){
        this.position = new Vector2(30, 10);
        quadrosDaAnimacao = TextureRegion.split(textura, 21, 24);
        andarParaFrente = new Animation(0.1f,
        quadrosDaAnimacao[0][0], // 1ª linha, 1ª coluna
        quadrosDaAnimacao[0][1], // idem, 2ª coluna
        quadrosDaAnimacao[0][2],
        quadrosDaAnimacao[0][3],
        quadrosDaAnimacao[0][4]);
        andarParaFrente.setPlayMode(PlayMode.LOOP_PINGPONG);
        andarParaDireita = new Animation(0.1f,
        quadrosDaAnimacao[1][0], // 1ª linha, 1ª coluna
        quadrosDaAnimacao[1][1], // idem, 2ª coluna
        quadrosDaAnimacao[1][2],
        quadrosDaAnimacao[1][3],
        quadrosDaAnimacao[1][4]);
        andarParaDireita.setPlayMode(PlayMode.LOOP_PINGPONG);
        andarParaTras = new Animation(0.1f,
        quadrosDaAnimacao[2][0], // 1ª linha, 1ª coluna
        quadrosDaAnimacao[2][1], // idem, 2ª coluna
        quadrosDaAnimacao[2][2],
        quadrosDaAnimacao[2][3],
        quadrosDaAnimacao[2][4]);
        andarParaTras.setPlayMode(PlayMode.LOOP_PINGPONG);
        andarParaEsquerda = new Animation(0.1f,
        quadrosDaAnimacao[3][0], // 1ª linha, 1ª coluna
        quadrosDaAnimacao[3][1], // idem, 2ª coluna
        quadrosDaAnimacao[3][2],
        quadrosDaAnimacao[3][3],
        quadrosDaAnimacao[3][4]);
        andarParaEsquerda.setPlayMode(PlayMode.LOOP_PINGPONG);
        animacaoAtual=andarParaFrente;
    tempoDaAnimacao = 0;
    }
    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) ){
            animacaoAtual=andarParaDireita;
            position.x++;
        }else
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) ){
           animacaoAtual=andarParaEsquerda;
           position.x--;
        }else
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
           animacaoAtual=andarParaTras;
           position.y++;
        }else
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) ){
         animacaoAtual=andarParaFrente;
         position.y--;
        }else{
            tempoDaAnimacao=0.2f;
        }
       tempoDaAnimacao += Gdx.graphics.getDeltaTime();
    }
    public void render(SpriteBatch batch){
           TextureRegion quadroAtual  = (TextureRegion) animacaoAtual.getKeyFrame(tempoDaAnimacao);
           batch.draw(quadroAtual, position.x, position.y);
    }
}
