package com.example.khuyn.quizapp;

/**
 * Created by khuyn on 2/6/2018.
 */

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;
    private int hint;

    public Question(int mTextResId, boolean mAnswerTrue, int hint){
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
        this.hint = hint;
    }

    public int getmTextResId() {
        return mTextResId;
    }

    public void setmTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public boolean ismAnswerTrue() {
        return mAnswerTrue;
    }

    public int getHint() {
        return hint;
    }

    public void setHint(int hint) {
        this.hint = hint;
    }




}
