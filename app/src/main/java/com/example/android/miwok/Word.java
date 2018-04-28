package com.example.android.miwok;

public class Word {

    private String mMiwokeTranslation;
    private String mEnglishTranslation;
    private int mAudioRecoureId;
    private int mImageResource = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation, int audioRecoureId) {

        mEnglishTranslation = defaultTranslation;
        mMiwokeTranslation = miwokTranslation;
        mAudioRecoureId = audioRecoureId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageView, int audioResourceId) {

        mEnglishTranslation = defaultTranslation;
        mMiwokeTranslation = miwokTranslation;
        mImageResource = imageView;
        mAudioRecoureId = audioResourceId;
    }

    public String getDefaultTranslation(){

        return mEnglishTranslation;
    }

    public String getmMiwokeTranslation() {

        return mMiwokeTranslation;
    }


    public int getImageView() {
        return mImageResource;
    }

    /**
     * Returns if Word has an Image or not
     * @return
     */
    public boolean hasImage(){

        return mImageResource != NO_IMAGE_PROVIDED;

    }

    public int getAudioResourceId() {

        return mAudioRecoureId;
    }

}
