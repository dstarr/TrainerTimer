package com.elegantcode.trainertimer;

import android.os.CountDownTimer;

import com.elegantcode.trainertimer.viewmodels.ActionButtonViewModel;
import com.elegantcode.trainertimer.viewmodels.TimeViewModel;

/**
 * Created by dxstarr on 9/3/17.
 */

public class MainModel {

    private int seconds;

    private TimeViewModel timeViewModel;
    private ActionButtonViewModel actionButtonViewModel;
    private int millis = 1000;
    private IObserver observer;
    private CountDownTimer countDownTimer;

    public MainModel(IObserver observer) {
        this.observer = observer;
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

    public void start() {
        initCountDownTimer();
        countDownTimer.start();
    }

    private void initCountDownTimer() {

        countDownTimer = new CountDownTimer(seconds * millis, millis) {
            @Override
            public void onTick(long l) {
                seconds--;
                timeViewModel.setSeconds(String.valueOf(seconds));
                setTimeViewState();
                setActionViewState();
                observer.update();
            }

            @Override
            public void onFinish() {
                seconds = 0;
                timeViewModel.setSeconds(String.valueOf(seconds));
                setTimeViewState();
                setActionViewState();

                observer.update();
            }
        };
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
