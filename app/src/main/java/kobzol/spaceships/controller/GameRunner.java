package kobzol.spaceships.controller;

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

    public void start() {
        this.running = true;

        this.thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running)
                {
                    for (LoopStartListener listener : listeners)
                    {
                        listener.onLoopStarted();
                    }

                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    {

                    }
                }
            }
        });

        this.thread.start();
    }
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
