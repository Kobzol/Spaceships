package kobzol.spaceships.controller;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Thread that executes the game loop.
 */
public class GameRunner {
    private final int fps;
    private List<LoopStartListener> listeners;

    private Thread thread;
    private boolean running;

    public GameRunner(int fps) {
        this.fps = fps;
        this.listeners = new ArrayList<LoopStartListener>();
    }

    public int getFps() {
        return this.fps;
    }
    public void addLoopStartListener(LoopStartListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Starts the game loop.
     */
    public void start() {
        if (!this.running)
        {
            this.running = true;
            this.thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    final int skipFrames = 1000 / fps;
                    long nextFrameTime = getCurrentTime();
                    long sleepTime;

                    while (running)
                    {
                        for (LoopStartListener listener : listeners)
                        {
                            listener.onLoopStarted();
                        }

                        nextFrameTime += skipFrames;
                        sleepTime = nextFrameTime - getCurrentTime();

                        if (sleepTime > 0)
                        {
                            try
                            {
                                Thread.sleep(sleepTime);
                            }
                            catch (InterruptedException e)
                            {

                            }
                        }
                        else
                        {
                            Log.w("Game loop", "Game lagging");
                        }
                    }
                }
            });
        }

        this.thread.start();
    }

    private long getCurrentTime() {
        return System.nanoTime() / 1000000;
    }

    /**
     * Stops the game loop.
     */
    public void stop() {
        if (this.thread != null)
        {
            this.running = false;

            try
            {
                this.thread.join();
            }
            catch (InterruptedException e)
            {

            }
        }
    }
}
