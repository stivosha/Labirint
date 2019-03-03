package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Simple_actor extends Actor {
    private Sprite sprite;


    public Simple_actor(Sprite sprite){
        this.sprite = sprite;
        this.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch,parentAlpha);
        //super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        sprite.setBounds(getX(),getY(),getWidth(),getHeight());
        super.act(delta);
    }
}