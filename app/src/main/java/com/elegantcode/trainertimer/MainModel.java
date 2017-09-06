package com.elegantcode.trainertimer;

import com.elegantcode.trainertimer.ViewModels.ActionButtonViewModel;
import com.elegantcode.trainertimer.ViewModels.TimeViewModel;

/**
 * Created by dxstarr on 9/3/17.
 */

public class MainModel {

    private int seconds;

    private TimeViewModel timeViewModel;
    private ActionButtonViewModel actionButtonViewModel;

    public MainModel() {
        seconds = 0;
        timeViewModel = new TimeViewModel();
        actionButtonViewModel = new ActionButtonViewModel();
    }

    public void addMinutes(int min) {

        addSeconds(min * 60);
    }

    public void addSeconds(int sec) {

        if (seconds + sec > 3600) {
            seconds = 3600;
        } else if((seconds + sec) < 0) {
            seconds = 0;
        } else {
            seconds += sec;
        }

        setTimeViewState();
        setActionViewState();
    }

    public TimeViewModel getTimeRemaining() {
        return timeViewModel;
    }

    public ActionButtonViewModel getActionButtonState() {
        return actionButtonViewModel;
    }

    public TimeViewModel resetTime() {
        seconds = 0;
        timeViewModel = new TimeViewModel();
        return timeViewModel;
    }

    private void setActionViewState() {

        if(seconds > 0) {
            actionButtonViewModel.setStartEnabled(true);
            actionButtonViewModel.setResetEnabled(true);
            return;
        }

        actionButtonViewModel.setStartEnabled(false);
        actionButtonViewModel.setResetEnabled(false);
    }

    private void setTimeViewState() {
        timeViewModel.setSeconds(formatNumber(seconds % 60));
        timeViewModel.setMinutes(formatNumber(seconds/60));
    }

    private String formatNumber(int number) {

        String sNumber = String.valueOf(number);

        if(number < 10) {
            sNumber = "0" + sNumber;
        }

        return sNumber;
    }

}
