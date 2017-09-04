package com.elegantcode.trainertimer.ViewModels;

/**
 * Created by dxstarr on 9/4/17.
 */

public class ActionButtonViewModel {

    private boolean isPaused = false;
    private boolean isStartEnabled = false;
    private boolean isResetEnabled = false;

    public boolean isStartEnabled() {
        return isStartEnabled;
    }

    public void setStartEnabled(boolean enabled) {
        isStartEnabled = enabled;
    }

    public boolean isResetEnabled() {
        return isResetEnabled;
    }

    public void setResetEnabled(boolean enabled) {
        isResetEnabled = enabled;
    }

    public String getStartButtonText() {

        if(isPaused)
            return "Paused";

        return "Start";
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

}
