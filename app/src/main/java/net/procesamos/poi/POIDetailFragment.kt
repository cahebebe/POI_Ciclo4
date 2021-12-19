package net.procesamos.poi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide


class POIDetailFragment : Fragment() {
    private var paramName: String? = null
    private var paramDescription: String? = null
    private var paramPicture: String? = null
    private var paramRate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramName = it.getString("paramName")
            paramDescription = it.getString("paramDescription")
            paramRate = it.getString("paramRate")
            paramPicture = it.getString("paramPicture")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poi_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.nombre_ciudad).text = paramName
        view.findViewById<TextView>(R.id.descripcion).text = paramDescription
        val calificacion = getString(R.string.calificacion) + ": " + paramRate
        view.findViewById<TextView>(R.id.calificacion).setText(calificacion)
        Glide.with(view).load(paramPicture).into(view.findViewById(R.id.imagen_principal))

    }


}