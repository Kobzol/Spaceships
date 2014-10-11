package kobzol.spaceships.game;

import android.app.Activity;
import android.graphics.Canvas;

import kobzol.spaceships.controller.SpaceDirector;
import kobzol.spaceships.view.GameCanvas;

/**
 * Creates and controls the game.
 *
 * GameController runs the main game loop and contains all of the game objects.
 */
public class Game {
    public static final int GAME_FPS = 25;

    private GameState gameState;

    private final GameRunner gameRunner;
    private final GameCanvas gameCanvas;

    private final SpaceDirector spaceDirector;

    private final Activity context;

    public Game(Activity context) {
        this.gameState = GameState.CREATED;

        this.gameRunner = new GameRunner(Game.GAME_FPS);
        this.gameRunner.addLoopStartListener(new LoopStartListener() {
            @Override
            public void onLoopStarted() {
                updateAll();
            }
        });

        this.gameCanvas = new GameCanvas(context);
        this.spaceDirector = new SpaceDirector(this.gameCanvas);

        this.context = context;
    }

    /**
     * Registers and displays the game canvas at the given context.
     * @param context activity
     */
    public void registerContentView(Activity context) {
        context.setContentView(this.gameCanvas);
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
        this.spaceDirector.update();

        Canvas canvas = this.gameCanvas.startDrawing();

        if (canvas != null)
        {
            this.spaceDirector.draw(canvas);
            this.gameCanvas.stopDrawing(canvas);
        }
    }
}
