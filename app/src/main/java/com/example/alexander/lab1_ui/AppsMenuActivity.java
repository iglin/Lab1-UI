package com.example.alexander.lab1_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
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

  /*  @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            GridLayout gridView = (GridLayout) findViewById(R.id.grid1);
            gridView.setOrientation(GridLayout.VERTICAL);
           // gridView.setColumnCount(7);
            //gridView.setPadding(6, 6, 6, 6);
            gridView = (GridLayout) findViewById(R.id.grid2);
            gridView.setOrientation(GridLayout.VERTICAL);
           // gridView.setColumnCount(7);
           // gridView.setPadding(6, 6, 6, 6);
            gridView = (GridLayout) findViewById(R.id.grid3);
            //gridView.setColumnCount(7);
            gridView.setOrientation(GridLayout.VERTICAL);
         //   gridView.setPadding(6, 6, 6, 6);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            GridLayout gridView = (GridLayout) findViewById(R.id.grid1);
            gridView.setOrientation(GridLayout.HORIZONTAL);
            //gridView.setColumnCount(4);
            //gridView.setPadding(9, 9, 9, 9);
            gridView = (GridLayout) findViewById(R.id.grid2);
            gridView.setOrientation(GridLayout.HORIZONTAL);
            //gridView.setColumnCount(4);
            //gridView.setPadding(9, 9, 9, 9);
            //gridView.setOrientation(GridLayout.VERTICAL);
            gridView = (GridLayout) findViewById(R.id.grid3);
            gridView.setOrientation(GridLayout.HORIZONTAL);
            //gridView.setColumnCount(4);
            //gridView.setPadding(9, 9, 9, 9);
        }
    }*/
}
