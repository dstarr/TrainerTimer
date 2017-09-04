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

    MainModel model = new MainModel();

    public MainPresenter (TextView minutes, TextView seconds) {

        tvMinutes = minutes;
        tvSeconds = seconds;

        MainViewModel viewModel = model.getTimeRemaining();

        tvMinutes.setText(viewModel.getMinutes());
        tvSeconds.setText(viewModel.getSeconds());
    }

    public void handleNumberClick(int btnClicked) {

        switch(btnClicked) {

            case R.id.button_add10s:
                model.addSeconds(10);
                break;

            case R.id.button_minus10s:
                model.addSeconds(-10);
                break;

            case R.id.button_add1m:
                model.addMinutes(1);
                break;

            case R.id.button_minus1m:
                model.addMinutes(-1);
                break;

            case R.id.button_add5m:
                model.addMinutes(5);
                break;

            case R.id.button_minus5m:
                model.addMinutes(-5);
                break;

        }

        MainViewModel viewModel = model.getTimeRemaining();

        tvMinutes.setText(viewModel.getMinutes());
        tvSeconds.setText(viewModel.getSeconds());


    }
}
