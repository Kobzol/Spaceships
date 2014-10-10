package kobzol.spaceships.controller;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kobzol.spaceships.model.GameObject;
import kobzol.spaceships.view.GameCanvas;

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
    private final GameCanvas gameCanvas;

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

        this.gameCanvas = new GameCanvas(context);
        this.gameCanvas.setFocusable(true);
        this.gameCanvas.addInputListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                updateInput(motionEvent);
                return true;
            }
        });

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
     * Initializes the game (should be called only once).
     */
    public void initializeGame() {

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

    /**
     * Updates the models according to the input.
     * @param event touch event from the user
     */
    private void updateInput(MotionEvent event) {
        Toast.makeText(this.context, "Touch event fired", Toast.LENGTH_SHORT).show();
    }
}
