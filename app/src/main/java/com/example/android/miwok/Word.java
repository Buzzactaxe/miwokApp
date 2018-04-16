package com.example.android.miwok;

public class Word {

    private String mMiwokeTranslation;
    private String mEnglishTranslation;

    public Word(String defaultTranslation, String miwokTranslation) {

        mEnglishTranslation = defaultTranslation;
        mMiwokeTranslation = miwokTranslation;
    }

    public String getDefaultTranslation(){

        return mEnglishTranslation;
    }

    public String getmMiwokeTranslation() {

        return mMiwokeTranslation;
    }

}
