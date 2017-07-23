package com.dan.mikkeliguidetour;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dan.mikkeliguidetour.SupportingClass.Phrase;
import com.dan.mikkeliguidetour.SupportingClass.PhraseAdapter;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    // display a list pf useful finnish phrases to users
    // enable the user to play the audio sound of each phrase

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;
    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        // create and add phrase into new ArrayList<Phrase> object names phrases
        final ArrayList<Phrase> phrases = new ArrayList<Phrase>();
        phrases.add(new Phrase(getString(R.string.hello_finnish), getString(R.string.hello_english), R.raw.terve));
        phrases.add(new Phrase(getString(R.string.welcome_finnish), getString(R.string.welcome_english), R.raw.tervetuloa));
        phrases.add(new Phrase(getString(R.string.sorry_finnish), getString(R.string.sorry_english), R.raw.anteeksi));
        phrases.add(new Phrase(getString(R.string.thank_you_finnish), getString(R.string.thank_you_english), R.raw.kiitos));
        phrases.add(new Phrase(getString(R.string.introduce_name_finnish), getString(R.string.introduce_name_english), R.raw.minun_nimi_on));

        //create new phrase adapter object
        PhraseAdapter phraseAdapter = new PhraseAdapter(this, phrases);
        //find phraselistview by id
        ListView phraselistView = (ListView) findViewById(R.id.list);
        //using phrase adapter to set the list of phrases into the phraselistView
        phraselistView.setAdapter(phraseAdapter);

        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //  play the audio when the image is click
        phraselistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //release media to play new one
                releaseMediaPlayer();

                // Get the current phrase
                Phrase phrase = phrases.get(position);

                // Request audio focus to play the audio file.
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Start the audio file
                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, phrase.getAudioResourceId());
                    mMediaPlayer.start();

                    // Setup a listener on the media player
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

    }
// release media when the activity stops
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean media
     */
    private void releaseMediaPlayer() {
        // If true, the media is playing a audio
        if (mMediaPlayer != null) {
            // release media player resources
            mMediaPlayer.release();

            // Set the media player back to null.
            mMediaPlayer = null;

            // unregisters the AudioFocusChangeListener to get no more callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
