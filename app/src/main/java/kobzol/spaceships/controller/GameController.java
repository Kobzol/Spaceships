package kobzol.spaceships.controller;

import android.app.Activity;

/**
 * Creates and controls the game.
 *
 * GameController runs the main game loop and contains all of the game objects.
 */
public class GameController {
    public static final int GAME_FPS = 25;

    private GameState gameState;

    private final GameRunner gameRunner;
    private final WorldController worldController;

    private final Activity context;

    public GameController(Activity context) {
        this.gameState = GameState.CREATED;

        this.gameRunner = new GameRunner(GameController.GAME_FPS);
        this.gameRunner.addLoopStartListener(new LoopStartListener() {
            @Override
            public void onLoopStarted() {
                updateAll();
            }
        });

        this.worldController = new WorldController(context);

        this.context = context;
    }

    /**
     * Registers and displays the game canvas at the given context.
     * @param context activity
     */
    public void registerContentView(Activity context) {
        this.worldController.registerContentView(context);
    }

    /**
     * Initializes the game (should be called only once).
     */
    public void initializeGame() {
        this.worldController.initializeGame();
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
        this.worldController.updateAll();
    }
}
