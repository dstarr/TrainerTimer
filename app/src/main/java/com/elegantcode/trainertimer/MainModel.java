package com.elegantcode.trainertimer;

/**
 * Created by dxstarr on 9/3/17.
 */

public class MainModel {

    private int seconds = 0;


    public void addMinutes(int min) {
        seconds += min * 60;
    }

    public void addSeconds(int sec) {

        seconds += sec;
    }

    public MainViewModel getTimeRemaining() {
        return new MainViewModel(getMinutes(), getSeconds());
    }

    private String getMinutes() {

        if (seconds < 1) {
            return formatNumber(0);
        }

        int minutes = seconds / 60;

        return formatNumber(minutes);

    }

    private String getSeconds() {

        if (seconds < 1) {
            return formatNumber(0);
        }

        int secondsRemaining = seconds % 60;

        return formatNumber(secondsRemaining);
    }

    private String formatNumber(int number) {

        String sNumber = String.valueOf(number);

        if(number < 10) {
            sNumber = "0" + sNumber;
        }

        return sNumber;
    }

}
