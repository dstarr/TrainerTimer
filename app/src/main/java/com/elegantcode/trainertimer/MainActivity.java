package com.elegantcode.trainertimer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    MainPresenter mainPresenter;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView tvSeconds = (TextView) findViewById(R.id.text_seconds);
        TextView tvMinutes = (TextView) findViewById(R.id.text_minutes);
        mainPresenter = new MainPresenter(tvMinutes, tvSeconds);

        initButtonState();

    }


    public void buttonHandler(View view) {

        switch(view.getId()) {

            case R.id.button_add10s:
            case R.id.button_minus10s:
            case R.id.button_add1m:
            case R.id.button_minus1m:
            case R.id.button_add5m:
            case R.id.button_minus5m:

                mainPresenter.handleNumberClick(view.getId());

                return;
        }

    }

    private void initButtonState() {

        Button startButton = (Button) findViewById(R.id.button_start);
        startButton.setEnabled(false);

        Button resetLastButton = (Button) findViewById(R.id.button_reset_last);
        resetLastButton.setEnabled(false);

        Button resetAllButton = (Button) findViewById(R.id.button_reset_0);
        resetAllButton.setEnabled(false);

    }
}
