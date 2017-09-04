package com.elegantcode.trainertimer;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
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
        }

        updateTimeRemaining();
        updateActionButtonState();

    }

    public void resetTime() {

        TextView seconds = (TextView) activity.findViewById(R.id.text_seconds);
        TextView minutes = (TextView) activity.findViewById(R.id.text_minutes);

        TimeViewModel timeViewModel = new TimeViewModel();

        seconds.setText(timeViewModel.getSeconds());
        minutes.setText(timeViewModel.getMinutes());

        ActionButtonViewModel actionButtonViewModel = new ActionButtonViewModel();

        Button startButton = (Button) activity.findViewById(R.id.button_start);
        startButton.setEnabled(actionButtonViewModel.isStartEnabled());

        Button resetButton = (Button) activity.findViewById(R.id.button_reset_0);
        resetButton.setEnabled(actionButtonViewModel.isResetEnabled());

    }

    private void updateTimeRemaining() {

        TimeViewModel viewModel = model.getTimeRemaining();

        TextView seconds = (TextView) activity.findViewById(R.id.text_seconds);
        TextView minutes = (TextView) activity.findViewById(R.id.text_minutes);

        seconds.setText(viewModel.getSeconds());
        minutes.setText(viewModel.getMinutes());

        updateActionButtonState();
    }

    private void updateActionButtonState() {

        TimeViewModel timeViewModel = model.getTimeRemaining();
        ActionButtonViewModel actionButtonViewModel = new ActionButtonViewModel(timeViewModel.getMinutes(), timeViewModel.getSeconds());

        Button startButton = (Button) activity.findViewById(R.id.button_start);
        startButton.setEnabled(actionButtonViewModel.isStartEnabled());
        startButton.setText(actionButtonViewModel.getStartButtonText());

        Button resetButton = (Button) activity.findViewById(R.id.button_reset_0);
        resetButton.setEnabled(actionButtonViewModel.isResetEnabled());

    }
}
