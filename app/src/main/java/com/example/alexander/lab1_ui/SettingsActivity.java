package com.example.alexander.lab1_ui;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.annotation.RequiresApi;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by user on 24.12.2016.
 */

public class SettingsActivity extends PreferenceActivity implements DatePickerDialog.OnDateSetListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
        Preference btnDateFilter = (Preference) findPreference("btnDateFilter");
        btnDateFilter.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onPreferenceClick(Preference preference) {
                showDateDialog();
                return false;
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
       // Log.i("dasd","year "+i+" month "+i2+" day "+i3);
    }

    private void showDateDialog(){
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(this,this, year, month, day).show();

    }
}
