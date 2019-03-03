package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import static com.mygdx.game.Screens.Profile.count_of_map;

public class List_of_maps implements Screen {
    private Table table;
    private Stage stage;
    private Sprite plus, one;
    private final int SIZE=  6;

    public List_of_maps(){
        table = new Table();
        stage = new Stage();
        plus = new Sprite(new Texture(Gdx.files.internal("buttons\\plus_button_47x14.png")));
        one = new Sprite(new Texture(Gdx.files.internal("buttons\\onet_button_47x14.png")));
        if (count_of_map == 0){
            table.add(new Image(plus)).minWidth(47f*SIZE).minHeight(14f*SIZE).padBottom(20f);
        }else{
            table.add(new Image(one)).minWidth(47f*SIZE).minHeight(14f*SIZE).padBottom(20f);
        }
        table.row();
        table.setFillParent(true);
    }

    @Override
    public void show() {
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
}
