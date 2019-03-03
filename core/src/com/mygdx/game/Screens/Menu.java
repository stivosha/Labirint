package com.mygdx.game.Screens;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.mygdx.game.Simple_actor;
import com.mygdx.game.net.Client;
import static com.mygdx.game.MyGdxGame.SIZE;


public class Menu implements Screen {

    private static Table table;
    private Stage stage;
    private Sprite sprite1;
    private Sprite sprite2;
    private Simple_actor btn_login;
    private Image image_login, image_reg;
    private TextField nameText, passwordText;
    private Skin skin;
    private Game game;
    public static boolean successful_login = false;
    public static String main_login;

    public Menu(Game game) {
        try{
            skin = new Skin(Gdx.files.internal("uiskin.json"));
            skin.getFont("default-font").getData().setScale(5f);
            sprite1 = new Sprite(new Texture(Gdx.files.internal("buttons\\log_in_button_71x14.png")));
            sprite2 = new Sprite(new Texture(Gdx.files.internal("buttons\\registration_button_71x14.png")));
        }catch (Exception e){
            skin = new Skin(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\uiskin.json"));
            skin.getFont("default-font").getData().setScale(5f);
            sprite1 = new Sprite(new Texture(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\buttons\\log_in_button_71x14.png")));
            sprite2 = new Sprite(new Texture(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\buttons\\registration_button_71x14.png")));
        }
        stage = new Stage();
        sprite1.setBounds(0,0, 71f*SIZE, 14f*SIZE);
        sprite2.setBounds(0,0, 71f*SIZE, 14f*SIZE);
        nameText = new TextField("",skin);
        passwordText = new TextField("", skin);
        table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        image_login = new Image(new SpriteDrawable(sprite1));
        image_reg = new Image(new SpriteDrawable(sprite2));

        table.add(nameText).minWidth(71f*SIZE).minHeight(14f*SIZE).padBottom(25f);
        table.row();
        table.add(passwordText).minWidth(71f*SIZE).minHeight(14f*SIZE).padBottom(50f);
        table.row();
        table.add(image_login).padBottom(20f);
        table.row();
        table.add(image_reg);
        this.game = game;
    }


    @Override
    public void show() {
        image_login.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String login = nameText.getText();
                String password = passwordText.getText();
                Client client = new Client("login@"+login+"@"+password);
                super.clicked(event, x, y);
            }
        });
        image_reg.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String login = nameText.getText();
                String password = passwordText.getText();
                Client client = new Client("reg@"+login+"@"+password);
                super.clicked(event, x, y);
            }
        });
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.46F, 0.53F, 0.6F, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act();
        if (successful_login){
            game.setScreen(new Profile(main_login));
        }
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
