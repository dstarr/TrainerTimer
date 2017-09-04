package com.elegantcode.trainertimer.ViewModels;

/**
 * Created by dxstarr on 9/4/17.
 */

public class ActionButtonViewModel {

    private boolean isPaused = false;

    private final String minutes;
    private final String seconds;

    public ActionButtonViewModel() {
        this("00", "00");
    }

    public ActionButtonViewModel(String min, String sec) {
        minutes = min;
        seconds = sec;
        isPaused = false;
    }

    public boolean isStartEnabled() {

        return (minutes != "00" || seconds != "00");
    }

    public boolean isResetEnabled() {

        return ((minutes != "00" || seconds != "00"));
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
