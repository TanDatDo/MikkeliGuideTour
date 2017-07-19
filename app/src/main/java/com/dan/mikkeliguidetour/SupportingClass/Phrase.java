package com.dan.mikkeliguidetour.SupportingClass;

/**
 * Created by Dat T Do on 7/19/2017.
 */

public class Phrase {

    /**
     * the phrase in Finnish
     */
    private String mFinnishPhrase;

    /**
     * the phrase translation
     */
    private String mTranslation;

    /**
     * Audio resource ID for the word
     */
    private int mAudioResourceId;


    /**
     * Create a new Phrase object.
     *
     * @param translation     is the phrase tranlation in a language that the user is already familiar with
     *                        (such as English)
     * @param finnishPhrase   is the phrase in the Finnish language
     * @param audioResourceId is the resource ID for the audio file associated with this phrase
     */
    public Phrase(String finnishPhrase, String translation, int audioResourceId) {
        mFinnishPhrase = finnishPhrase;
        mTranslation = translation;
        mAudioResourceId = audioResourceId;
    }


    /**
     * Get the translation of the phrase.
     */
    public String getTranslation() {
        return mTranslation;
    }

    /**
     * Get the Finnish phrase.
     */
    public String getFinnishPhrase() {
        return mFinnishPhrase;
    }


    /**
     * Return the audio resource ID of the phrase.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
