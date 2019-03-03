package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.Screens.Constructor;
import com.mygdx.game.Screens.List_of_maps;
import com.mygdx.game.Screens.Menu;
import com.mygdx.game.Screens.Profile;

public class MyGdxGame extends Game {

	public final static int SIZE = 10;

	@Override
	public void create() {
		//setScreen(new Menu(this));
		setScreen(new Constructor());
	}
}
