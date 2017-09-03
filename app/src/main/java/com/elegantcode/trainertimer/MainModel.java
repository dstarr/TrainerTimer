package com.elegantcode.trainertimer;

/**
 * Created by dxstarr on 9/3/17.
 */

public class MainModel {

    private int minutes = 0;
    private int seconds = 0;


    public void addMinutes(int min) {
        minutes += min;
    }

    public void addSeconds(int sec) {
        seconds += sec;
    }

    public String getMinutes() {

        if(minutes < 0) { minutes = 0; }

        return formatNumber(minutes);
    }

    public String getSeconds() {

        if(seconds < 0) { seconds = 0; }

        return formatNumber(seconds);
    }

    private String formatNumber(int number) {

        String sNumber = String.valueOf(number);

        if(number < 10) {
            sNumber = "0" + sNumber;
        }

        return sNumber;
    }

}
