package kobzol.spaceships.ui;

import android.app.Activity;
import android.os.Bundle;

import kobzol.spaceships.game.Game;

public class GameActivity extends Activity {
    private Game game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.game = new Game(this);
        game.registerContentView(this);
        game.initializeGame();

        game.start();
    }

    @Override
    protected void onStop() {
        this.game.stop();
        super.onStop();
    }

    @Override
    protected void onRestart() {
        this.game.start();
        super.onRestart();
    }
}
