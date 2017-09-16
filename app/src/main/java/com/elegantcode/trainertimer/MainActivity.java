package com.elegantcode.trainertimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    MainPresenter presenter;
    boolean isTicking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
    }

    public void numberButtonClickHandler(View view) {

        presenter.numberClicked(view);
    }

    public void resetButtonClickHandler(View view) {
        presenter.resetTimer();
    }

    public void startButtonClickHandler(View view) {
        presenter.startTimer();
    }

}
