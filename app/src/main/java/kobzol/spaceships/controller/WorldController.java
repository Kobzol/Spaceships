package kobzol.spaceships.controller;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import kobzol.spaceships.model.GameObject;
import kobzol.spaceships.view.GameCanvas;

/**
 * Controls the game world and logic.
 */
public class WorldController {
    private final GameCanvas gameCanvas;
    private final List<GameObject> gameObjects;

    public WorldController(Activity context) {
        this.gameCanvas = new GameCanvas(context);
        this.gameCanvas.setFocusable(true);
        this.gameCanvas.addInputListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                updateInput(motionEvent);
                return true;
            }
        });

        this.gameObjects = new ArrayList<GameObject>();
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

    public void updateAll() {
        for (GameObject object : this.gameObjects)
        {
            object.update();
        }

        Canvas canvas = this.gameCanvas.startDrawing();

        if (canvas != null)
        {
            canvas.drawColor(Color.BLACK);

            synchronized (this.gameCanvas) {
                for (GameObject object : this.gameObjects)
                {
                    object.draw(canvas);
                }
            }

            this.gameCanvas.stopDrawing(canvas);
        }

        Log.i("Game loop", "Game updated");
    }
    /**
     * Updates the models according to the input.
     * @param event touch event from the user
     */
    private void updateInput(MotionEvent event) {
        for (GameObject object : this.gameObjects)
        {
            object.onTouch(event);
        }
    }
}
