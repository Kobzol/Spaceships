package kobzol.spaceships.game;

/**
 * Thread that executes the game loop.
 */
public class GameRunner {
    private final int fps;
    private final LoopListener listener;

    private Thread thread;
    private boolean running;

    public GameRunner(int fps, LoopListener listener) {
        this.fps = fps;
        this.listener = listener;
    }

    public int getFps() {
        return this.fps;
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
                    long nextUpdateTime = getCurrentTime();
                    int loopCounter;

                    while (running)
                    {
                        loopCounter = 0;

                        while (getCurrentTime() > nextUpdateTime && loopCounter < 5)
                        {
                            listener.onUpdate();

                            nextUpdateTime += skipFrames;
                            loopCounter++;
                        }

                        listener.onDraw();
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
