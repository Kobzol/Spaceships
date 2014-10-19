package kobzol.spaceships.sound;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import kobzol.spaceships.R;

/**
 * Sound manager for playing sounds.
 */
public class SoundManager {
    public static MediaPlayer LASER_SOUND;
    public static MediaPlayer EXPLOSION_SOUND;

    public static void initialize(Context context) {
        LASER_SOUND = MediaPlayer.create(context, R.raw.laser);
        LASER_SOUND.setAudioStreamType(AudioManager.STREAM_MUSIC);

        EXPLOSION_SOUND = MediaPlayer.create(context, R.raw.explosion);
        EXPLOSION_SOUND.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    public static void release() {
        if (LASER_SOUND != null)
        {
            LASER_SOUND.release();
            LASER_SOUND = null;
        }

        if (EXPLOSION_SOUND != null)
        {
            EXPLOSION_SOUND.release();
            EXPLOSION_SOUND = null;
        }
    }

    /**
     * Plays a sound. If it is already playing, it stops and resets it.
     * @param mp media player
     */
    public static void playSound(MediaPlayer mp) {
        if (mp.isPlaying())
        {
            mp.pause();
            mp.seekTo(0);
        }

        mp.start();
    }
}
