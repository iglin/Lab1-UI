package com.example.alexander.lab1_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

/**
 * Created by user on 24.12.2016.
 */

public class AppsMenuActivity extends AppCompatActivity implements View.OnTouchListener {
    private float oldTouchValue = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps);

        final ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        // TODO Auto-generated method stub
        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN:
                oldTouchValue = event.getX();
                break;

            case MotionEvent.ACTION_UP:
                float currentX = event.getX();
                if (oldTouchValue < currentX)
                {
                    viewFlipper.showNext();
                }
                else if (oldTouchValue > currentX)
                {
                    viewFlipper.showPrevious();
                }
                break;
        }
        return true;
    }
}
