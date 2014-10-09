package kobzol.spaceships.controller;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import kobzol.spaceships.model.GameObject;

/**
 * Creates and controls the game.
 *
 * GameController runs the main game loop and contains all of the game objects.
 */
public class GameController {
    public static final int GAME_FPS = 50;

    private GameState gameState;
    private List<GameObject> objects;
    private final GameRunner gameRunner;

    private final Activity context;

    public GameController(Activity context) {
        this.gameState = GameState.CREATED;
        this.objects = new ArrayList<GameObject>();

        this.gameRunner = new GameRunner(GameController.GAME_FPS);
        this.gameRunner.addLoopStartListener(new LoopStartListener() {
            @Override
            public void onLoopStarted() {
                updateAll();
            }
        });

        this.context = context;
    }

    /**
     * Starts the game.
     */
    public void start() {
        this.gameState = GameState.RUNNING;
        this.gameRunner.start();
    }

    /**
     * Stops the game.
     */
    public void stop() {
        this.gameState = GameState.STOPPED;
        this.gameRunner.stop();
    }

    /**
     * Updates all contained game objects and causes them to redraw themselves.
     */
    private void updateAll() {
        for (GameObject object : this.objects)
        {
            object.update();
        }
    }
}
