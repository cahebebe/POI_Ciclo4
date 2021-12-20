import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import net.procesamos.poi.model.POIsModels
import net.procesamos.poi.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment : Fragment() {
    private lateinit var mutablePOIs: MutableList<POIsModels>
    private lateinit var adapterPOIs: POIsAdapter
    private lateinit var recyclerPOIs: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerPOIs = view.findViewById(R.id.listPOIs)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mutablePOIs = mutableListOf()
        recyclerPOIs.addItemDecoration(
            DividerItemDecoration(
                recyclerPOIs.context,
                DividerItemDecoration.VERTICAL
            )
        )
        adapterPOIs = POIsAdapter(mutablePOIs, recyclerPOIs.context) { POI ->
            poiOnClick(POI)
        }
        recyclerPOIs.adapter = adapterPOIs
        generatePOIs()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_settings -> {
                findNavController().navigate(R.id.settingsFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun poiOnClick(POI: POIsModels) {
        navigateToDetail(POI)
    }

    private fun navigateToDetail(POI: POIsModels) {
        val detailBundle = Bundle().apply {
            putString("paramName", POI.name)
            putString("paramDescription", POI.description)
            putString("paramPicture", POI.picture)
            putString("paramLatitude", POI.latitude)
            putString("paramLongitude", POI.longitude)
            val calificacion = getString(R.string.calificacion) + ": " + POI.rate
            putString("paramRate", calificacion)
            val temperatura = getString(R.string.temperatura) + ": " + POI.temperature + " °C"
            putString("paramTemperature", temperatura)
        }
        findNavController().navigate(R.id.actionFromListToDetail, detailBundle)
    }

    private fun generatePOIs() {
        APIClient.apiService.getPOIs().enqueue(object : Callback<MutableList<POIsModels>> {
            override fun onFailure(call: Call<MutableList<POIsModels>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<MutableList<POIsModels>>,
                response: Response<MutableList<POIsModels>>
            ) {
                val usersResponse = response.body()
                mutablePOIs.clear()
                usersResponse?.let { mutablePOIs.addAll(it) }
                adapterPOIs.notifyDataSetChanged()
            }
        })
    }

}