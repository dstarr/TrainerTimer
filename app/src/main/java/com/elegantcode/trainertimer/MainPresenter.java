package com.elegantcode.trainertimer;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.elegantcode.trainertimer.ViewModels.ActionButtonViewModel;
import com.elegantcode.trainertimer.ViewModels.TimeViewModel;

/**
 * Created by dxstarr on 9/2/17.
 */

public class MainPresenter {

    private MainModel model = new MainModel();
    private Activity activity;

    public MainPresenter(Activity act) {

        activity = act;
        resetTime();
    }

    public void numberClicked(View view) {

        switch (view.getId()) {

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

            case R.id.button_add10m:
                model.addMinutes(10);
                break;

            case R.id.button_minus10m:
                model.addMinutes(-10);
                break;
        }

        updateTimeRemaining();
        updateActionButtonState();
    }

    public void resetTime() {

        model.resetTime();
        updateTimeRemaining();
        updateActionButtonState();
    }

    private void updateTimeRemaining() {

        TextView seconds = activity.findViewById(R.id.text_seconds);
        TextView minutes = activity.findViewById(R.id.text_minutes);

        TimeViewModel timeViewModel = model.getTimeRemaining();

        seconds.setText(timeViewModel.getSeconds());
        minutes.setText(timeViewModel.getMinutes());

    }

    private void updateActionButtonState() {

        ActionButtonViewModel actionButtonViewModel = model.getActionButtonState();

        Button startButton = activity.findViewById(R.id.button_start);
        Button resetButton = activity.findViewById(R.id.button_reset_0);

        startButton.setEnabled(actionButtonViewModel.isStartEnabled());
        resetButton.setEnabled(actionButtonViewModel.isResetEnabled());

    }
}
