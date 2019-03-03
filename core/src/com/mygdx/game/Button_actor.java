package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Button_actor extends Image {

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(this.getColor());

        ((TextureRegionDrawable)getDrawable()).draw(batch, getX(),getY(),
                getOriginX(),getOriginY(),
                getWidth(),getHeight(),
                getScaleX(),getScaleY(),
                getRotation());
    }

    public Button_actor(Texture texture) {
        super(texture);
        setBounds(getX(), getY(), getWidth(), getHeight());
    }
}
