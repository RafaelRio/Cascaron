package com.example.cascaron.ui.preferencias;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.cascaron.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}