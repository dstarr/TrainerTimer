package com.elegantcode.trainertimer;

import com.elegantcode.trainertimer.ViewModels.ActionButtonViewModel;
import com.elegantcode.trainertimer.ViewModels.TimeViewModel;

/**
 * Created by dxstarr on 9/3/17.
 */

public class MainModel {

    private int seconds;

    TimeViewModel timeViewModel;
    ActionButtonViewModel actionButtonViewModel;

    public MainModel() {
        seconds = 0;
        timeViewModel = new TimeViewModel();
        actionButtonViewModel = new ActionButtonViewModel();
    }

    public void addMinutes(int min) {

        seconds += (min * 60);

        if (seconds > 3600) {
            seconds = 3600;
            return;
        }


        if(seconds < 0) {
            min = 0;
            seconds = 0;
        } else if ((seconds/60) < 0) {
            min = 0;
        }

        String strMinutes = formatNumber(seconds / 60);
        String strSeconds = formatNumber(seconds % 60);

        timeViewModel.setMinutes(strMinutes);
        timeViewModel.setSeconds(strSeconds);
    }

    public void addSeconds(int sec) {

        if (seconds + sec > 3600) {
            seconds = 3600;
            return;
        }

        if((seconds + sec) < 0) {
            seconds = 0;

            String strSeconds = formatNumber(this.seconds);
            timeViewModel.setSeconds(strSeconds);

            return;
        }

        seconds += sec;

        timeViewModel.setSeconds(formatNumber(seconds % 60));
        timeViewModel.setMinutes(formatNumber(seconds/60));
    }

    public TimeViewModel getTimeRemaining() {
        return timeViewModel;
    }

    public TimeViewModel resetTime() {
        seconds = 0;
        return new TimeViewModel();
    }

    private String formatNumber(int number) {

        String sNumber = String.valueOf(number);

        if(number < 10) {
            sNumber = "0" + sNumber;
        }

        return sNumber;
    }

}
