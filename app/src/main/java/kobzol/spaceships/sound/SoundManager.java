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

    public static void initialize(Context context) {
        LASER_SOUND = MediaPlayer.create(context, R.raw.laser);
        LASER_SOUND.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    public static void release() {
        if (LASER_SOUND != null)
        {
            LASER_SOUND.release();
            LASER_SOUND = null;
        }
    }
}
