package com.mygdx.game.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

//import static com.mygdx.game.Screens.Constructor.eWalls_up;

public class WallActor extends Actor{

    private Sprite sprite;
    private final int type;
    private final int id;
    private Boolean clicked = false;


    public WallActor(final Sprite sprite_, final int id, int type_){
        this.sprite = sprite_;
        this.type = type_;
        this.id = id;

        this.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                if (type == 1){
                    if (clicked){
                        clicked = false;
                        sprite.setTexture(new Texture(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\empty_wall2_2x10.png")));
                        System.out.println("Test");
                    } else {
                        clicked = true;
                        sprite.setTexture(new Texture(Gdx.files.internal("A:\\projects\\Labirint\\android\\assets\\wall_2x10.png")));

                    }
                }
                super.clicked(event, x, y);
            }
        });
    }


    @Override
    public void act (float delta){
        sprite.setBounds(getX(),getY(),getWidth(),getHeight());
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        sprite.draw(batch);
        super.draw(batch,parentAlpha);
    }
}