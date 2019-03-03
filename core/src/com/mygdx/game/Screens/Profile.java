package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import static com.mygdx.game.MyGdxGame.SIZE;

public class Profile implements Screen {

    private Table table;
    private Image btn_create_server, btn_connect, btn_profile, btn_maps, btn_exit;
    private Stage stage;
    protected static int count_of_map;

    public Profile(String login) {
        try{
            Sprite t = new Sprite(new Texture(Gdx.files.internal(
                    "buttons\\create_server_button_81x14.png")));
            t.setBounds(0,0,81f*SIZE, 14F*SIZE);
            btn_create_server = new Image(t);
            Sprite t2 = new Sprite(new Texture(Gdx.files.internal(
                    "buttons\\connect_button_81x14.png")));
            t2.setBounds(0,0,81f*SIZE,14f*SIZE);
            btn_connect = new Image(t2);
            Sprite t3 = new Sprite(new Texture(Gdx.files.internal(
                    "buttons\\profile_button_81x14.png")));
            t3.setBounds(0,0,81f*SIZE,14f*SIZE);
            btn_profile = new Image(t3);
            Sprite t4 = new Sprite(new Texture(Gdx.files.internal(
                    "buttons\\maps_button_81x14.png")));
            t4.setBounds(0,0,81f*SIZE,14f*SIZE);
            btn_maps = new Image(t4);
            Sprite t5 = new Sprite(new Texture(Gdx.files.internal(
                    "buttons\\exit_button_81x14.png")));
            t5.setBounds(0,0,81f*SIZE,14f*SIZE);
            btn_exit = new Image(t5);
        }catch (Exception e){
            Sprite t = new Sprite(new Texture(Gdx.files.internal(
                    "A:\\projects\\Labirint\\android\\assets\\buttons\\" +
                            "create_server_button_81x14.png")));
            t.setBounds(0,0,81f*SIZE, 14F*SIZE);
            btn_create_server = new Image(t);
            Sprite t2 = new Sprite(new Texture(Gdx.files.internal(
                    "A:\\projects" +
                            "\\Labirint\\android\\assets\\buttons\\connect_button_81x14.png")));
            t2.setBounds(0,0,81f*SIZE,14f*SIZE);
            btn_connect = new Image(t2);
        }
        table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage = new Stage();
        table.add(btn_create_server).minWidth(81f*SIZE).minHeight(14f*SIZE).padBottom(25f);
        table.row();
        table.add(btn_connect).minWidth(81f*SIZE).minHeight(14f*SIZE).padBottom(25f);
        table.row();
        table.add(btn_profile).minWidth(81f*SIZE).minHeight(14f*SIZE).padBottom(25f);
        table.row();
        table.add(btn_maps).minWidth(81f*SIZE).minHeight(14f*SIZE).padBottom(25f);
        table.row();
        table.add(btn_exit).minWidth(81f*SIZE).minHeight(14f*SIZE).padBottom(25f);
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
