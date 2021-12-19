package net.procesamos.poi

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class ParametersPOI : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.parameters_poi, rootKey)
    }
}