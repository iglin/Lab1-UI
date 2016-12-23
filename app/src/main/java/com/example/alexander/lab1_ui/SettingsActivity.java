package com.example.alexander.lab1_ui;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by user on 24.12.2016.
 */

public class SettingsActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
