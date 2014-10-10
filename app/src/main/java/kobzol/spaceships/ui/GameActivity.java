package kobzol.spaceships.ui;

import android.app.Activity;
import android.os.Bundle;

import kobzol.spaceships.controller.GameController;

public class GameActivity extends Activity {
    private GameController gameController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.gameController = new GameController(this);
        gameController.registerContentView(this);
        gameController.initializeGame();

        gameController.start();
    }

    @Override
    protected void onStop() {
        this.gameController.stop();
        super.onStop();
    }

    @Override
    protected void onRestart() {
        this.gameController.start();
        super.onRestart();
    }
}
