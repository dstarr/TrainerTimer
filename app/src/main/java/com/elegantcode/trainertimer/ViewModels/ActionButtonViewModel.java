package com.elegantcode.trainertimer.viewmodels;

/**
 * Created by dxstarr on 9/4/17.
 */

public class ActionButtonViewModel {

    private boolean startEnabled = false;
    private boolean resetEnabled = false;
    private String startButtonText;

    public boolean isStartEnabled() {

        setStartButtonText("Start");

        return startEnabled;
    }

    public void setStartEnabled(boolean startEnabled) {

        this.startEnabled = startEnabled;

    }

    public boolean isResetEnabled() {

        return resetEnabled;
    }

    public void setResetEnabled(boolean resetEnabled) {

        this.resetEnabled = resetEnabled;
    }

    public String getStartButtonText() {
        return startButtonText;
    }

    public void setStartButtonText(String startButtonText) {
        this.startButtonText = startButtonText;
    }
}
