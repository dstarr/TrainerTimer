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
    private boolean isTicking = false;

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
        } else if ((seconds + sec) < 0) {
            seconds = 0;
        } else {
            seconds += sec;
        }

        updateViewState();
        observer.update();
    }

    public void reset() {

        isTicking = false;
        seconds = 0;
        timeViewModel = new TimeViewModel();

        updateViewState();
        observer.update();
    }

    public void start() {

        if (!isTicking) {
            isTicking = true;
            initCountDownTimer();
            countDownTimer.start();
        } else {
            isTicking = false;
            countDownTimer.cancel();
        }

        updateViewState();
        observer.update();
    }

    public TimeViewModel getTimeRemaining() {
        return timeViewModel;
    }

    public ActionButtonViewModel getActionButtonState() {

        return actionButtonViewModel;
    }

    private void initCountDownTimer() {

        countDownTimer = new CountDownTimer(seconds * millis, millis) {

            @Override
            public void onTick(long l) {
                seconds--;
                isTicking = true;
                updateViewState();
                observer.update();
            }

            @Override
            public void onFinish() {
                isTicking = false;
                seconds = 0;
                updateViewState();
                observer.update();

            }
        };
    }

    private void updateViewState() {

        if (seconds > 0) {

            timeViewModel.setSeconds(formatNumber(seconds % 60));
            timeViewModel.setMinutes(formatNumber(seconds / 60));

            actionButtonViewModel.setStartEnabled(true);
            actionButtonViewModel.setResetEnabled(!isTicking);

            if (isTicking) {
                actionButtonViewModel.setStartButtonText("Pause");
            } else {
                actionButtonViewModel.setStartButtonText("Start");
            }
            return;
        }

        timeViewModel.setSeconds(formatNumber(0));
        timeViewModel.setMinutes(formatNumber(0));

        actionButtonViewModel.setStartEnabled(false);
        actionButtonViewModel.setResetEnabled(false);
        actionButtonViewModel.setStartButtonText("Start");


    }

    private String formatNumber(int number) {

        String sNumber = String.valueOf(number);

        if (number < 10) {
            sNumber = "0" + sNumber;
        }

        return sNumber;
    }
}
