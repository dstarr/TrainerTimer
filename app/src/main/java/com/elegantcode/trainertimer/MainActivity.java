package com.elegantcode.trainertimer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.elegantcode.trainertimer.ViewModels.ActionButtonViewModel;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    MainPresenter mainPresenter;
    ActionButtonViewModel actionButtonViewModel;
    boolean isTicking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initMainPresenter();
        updateActionButtonState();

    }

    public void numberButtonHandler(View view) {

        switch(view.getId()) {

            case R.id.button_add10s:
            case R.id.button_minus10s:
            case R.id.button_add1m:
            case R.id.button_minus1m:
            case R.id.button_add5m:
            case R.id.button_minus5m:

                mainPresenter.handleNumberClick(view.getId());
                updateActionButtonState();

                break;
        }
    }

    private void updateActionButtonState() {

        TextView seconds =  (TextView) findViewById(R.id.text_seconds);
        TextView minutes =  (TextView) findViewById(R.id.text_minutes);

        updateActionButtonViewModel(seconds, minutes);

        Button startButton = (Button) findViewById(R.id.button_start);
        startButton.setEnabled(actionButtonViewModel.isStartEnabled());
        startButton.setText(actionButtonViewModel.getStartButtonText());

        Button resetButton = (Button) findViewById(R.id.button_reset_0);
        resetButton.setEnabled(actionButtonViewModel.isResetEnabled());

    }


    private void updateActionButtonViewModel(TextView seconds, TextView minutes) {

        if(minutes.getText().toString() == "00" && seconds.getText().toString() == "00") {
            actionButtonViewModel.setStartEnabled(false);
            actionButtonViewModel.setResetEnabled(false);
        }

        if(isTicking) {
            actionButtonViewModel.setPaused(false);
            actionButtonViewModel.setStartEnabled(true);
            actionButtonViewModel.setResetEnabled(false);
        }
    }

    private void initMainPresenter() {
        TextView tvSeconds = (TextView) findViewById(R.id.text_seconds);
        TextView tvMinutes = (TextView) findViewById(R.id.text_minutes);
        mainPresenter = new MainPresenter(tvMinutes, tvSeconds);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };
}
