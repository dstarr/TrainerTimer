package com.elegantcode.trainertimer.ViewModels;

/**
 * Created by dxstarr on 9/3/17.
 */

public class TimeViewModel {

    private String seconds;
    private String minutes;


    public TimeViewModel() {
        this("00", "00");
    }

    public TimeViewModel(String min, String sec) {
        setMinutes(min);
        seconds = sec;
    }

    public String getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

}
