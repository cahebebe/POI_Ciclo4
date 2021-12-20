import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import net.procesamos.poi.R

class POIParametersFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.parameters_poi, rootKey)
    }
}