package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.mygdx.game.actors.WallActor;

import static com.mygdx.game.MyGdxGame.SIZE;

public class Constructor implements Screen {
    private Image[] block;
    private Image[] wall;
    private final int SIZE = 7;
    private Table table;
    private Stage stage;
    private final Sprite block_10x10, center_2x2, eWall_2x10,eWall_10x2, wall_2x10, wall_10x2, save_button;
    public static WallActor[] eWalls_up;

    public Constructor() {
        block_10x10 = new Sprite(new Texture(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\block_10x10.png")));
        center_2x2 = new Sprite(new Texture(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\center_2x2.png")));
        eWall_2x10 = new Sprite(new Texture(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\empty_wall2_2x10.png")));
        eWall_10x2 = new Sprite(new Texture(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\empty_wall2_10x2.png")));
        wall_2x10 = new Sprite(new Texture(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\wall_2x10.png")));
        wall_10x2 = new Sprite(new Texture(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\wall_10x2.png")));
        save_button = new Sprite(new Texture(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\buttons\\save_button_47x14.png")));
        table = new Table();
        stage = new Stage();
        table.setFillParent(true);
//        table.setDebug(true);
    }

    @Override
    public void show() {
        createMap(table, 10, 10);
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.46F, 0.53F, 0.6F, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    void createMap(Table table, int h, int w){
        Image[] centeres = new Image[(h+1)*(w+1)];
        for(int i =0; i < (h+1)*(w+1); i++){
            centeres[i] = new Image(center_2x2);
        }
        Image[] walls_up = new Image[2*w];
        for(int i =0; i < 2*w; i++){
            walls_up[i] = new Image(wall_2x10);
        }
        Image[] walls_down = new Image[2*h];
        for(int i =0; i < 2*h; i++){
            walls_down[i] = new Image(wall_10x2);
        }
        Image[] blocks = new Image[h*w];

        final WallActor[] eWalls_down = new WallActor[h*w];
        eWalls_up = new WallActor[h*w];
        for(int i =0; i < h*w; i++){

            blocks[i] = new Image(block_10x10);
//            eWalls_up[i] = new Image(eWall_10x2);
//            eWalls_down[i] = new Image(eWall_2x10);
            eWalls_up[i] = new WallActor(eWall_10x2, i, 1);
            eWalls_down[i] = new WallActor(eWall_2x10, i, 1);
//            final Image test = eWalls_up[i];
//            final Image test2 = eWalls_down[i];
//            eWalls_up[i].addListener(new ClickListener(){
//                @Override
//                public void clicked(InputEvent event, float x, float y) {
//                    test.setDrawable(new SpriteDrawable(wall_10x2));
//                    super.clicked(event, x, y);
//                }
//            });
//            eWalls_down[i].addListener(new ClickListener(){
//                @Override
//                public void clicked(InputEvent event, float x, float y) {
//                    test2.setDrawable(new SpriteDrawable(wall_2x10));
//                    super.clicked(event, x, y);
//                }
//            });
        }
        for(int i = 0; i < w; i++){
            table.add(centeres[i]).minWidth(2f*SIZE).minHeight(2f*SIZE);
            table.add(walls_up[i]).minWidth(10f*SIZE).minHeight(2f*SIZE);
        }
        table.add(centeres[w]).minWidth(2f*SIZE).minHeight(2f*SIZE);
        table.row();
        for(int i = 0; i < h*2; i++){
            if (i % 2 == 0){
                table.add(walls_down[i]).minHeight(10f*SIZE).minWidth(2f*SIZE);
                for(int u = 0; u < w-1; u++){
                    table.add(blocks[u+(i/2)*w]).minWidth(10f*SIZE).minHeight(10f*SIZE);
                    table.add(eWalls_down[u+(i/2)*(w-1)]).minHeight(10f*SIZE).minWidth(2f*SIZE);
                }
                table.add(blocks[w-1+(i/2)*w]).minHeight(10f*SIZE).minWidth(10f*SIZE);
                table.add(walls_down[i+1]).minHeight(10f*SIZE).minWidth(2f*SIZE);
                table.row();
            }else{
                if (i != h*2-1){
                    for (int u = 0;u < w; u++){
                        table.add(centeres[(w+1)*((i+1)/2)+u]).minHeight(2f*SIZE).minWidth(2f*SIZE);
                        table.add(eWalls_up[u+((i-1)/2)*w]).minHeight(2f*SIZE).minWidth(10f*SIZE);
                    }
                    table.add(centeres[(w+1)*((i+1)/2)+w]).minHeight(2f*SIZE).minWidth(2f*SIZE);
                    table.row();
                }else{
                    for (int u = 0;u < w; u++){
                        table.add(centeres[(w+1)*((i+1)/2)+u]).minHeight(2f*SIZE).minWidth(2f*SIZE);
                        table.add(walls_up[w+u]).minHeight(2f*SIZE).minWidth(10f*SIZE);
                    }
                    table.add(centeres[(w+1)*((i+1)/2)+w]).minHeight(2f*SIZE).minWidth(2f*SIZE);
                    table.row();
                }
            }
        }
        table.add(new Image(save_button)).colspan(w*2+1).minWidth(47f*SIZE).minHeight(14f*SIZE).padBottom(20f);
    }
    void setTexture(Image[] image,int i){
        image[i].setDrawable(new SpriteDrawable(wall_10x2));
    }
}
