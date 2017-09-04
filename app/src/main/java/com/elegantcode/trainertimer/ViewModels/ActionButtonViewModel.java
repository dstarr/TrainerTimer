package com.elegantcode.trainertimer.ViewModels;

/**
 * Created by dxstarr on 9/4/17.
 */

public class ActionButtonViewModel {

    private boolean isPaused = false;

    public boolean isStartEnabled(int seconds) {

        return (seconds > 0);
    }

    public boolean isResetEnabled(int seconds) {

        return (seconds > 0 && isPaused);
    }

    public String getStartButtonText() {

        if (isPaused)
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
