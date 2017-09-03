package com.elegantcode.trainertimer;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by dxstarr on 9/2/17.
 */

public class MainPresenter {

    TextView tvMinutes;
    TextView tvSeconds;

    public MainPresenter (TextView minutes, TextView seconds) {

        tvMinutes = minutes;
        tvSeconds = seconds;
    }

    public void handleNumberClick(int btnClicked) {

        int currentSeconds = Integer.parseInt(tvSeconds.getText().toString());
        int currentMinutes = Integer.parseInt(tvMinutes.getText().toString());

        switch(btnClicked) {

            case R.id.button_add10s:
                currentSeconds += 10;
                tvSeconds.setText(String.valueOf(currentSeconds));
                break;

            case R.id.button_minus10s:
                currentSeconds -= 10;
                tvSeconds.setText(String.valueOf(currentSeconds));
                break;

            case R.id.button_add1m:
                currentMinutes += 1;
                tvMinutes.setText(String.valueOf(currentMinutes));
                break;

            case R.id.button_minus1m:
                currentMinutes -= 1;
                tvMinutes.setText(String.valueOf(currentMinutes));
                break;

            case R.id.button_add5m:
                currentMinutes += 5;
                tvMinutes.setText(String.valueOf(currentMinutes));
                break;

            case R.id.button_minus5m:
                currentMinutes -= 5;
                tvMinutes.setText(String.valueOf(currentMinutes));
                break;

        }
    }
}
