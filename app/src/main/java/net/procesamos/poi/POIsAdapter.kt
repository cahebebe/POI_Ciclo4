package net.procesamos.poi

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class POIsAdapter(
    private val mutablePOI: MutableList<POIsModels>, private val context: Context, private val onClick: (POIsModels) -> Unit
) : RecyclerView.Adapter<POIsAdapter.POIViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): POIViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_poi_list,parent, false)
        return POIViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mutablePOI.size
    }

    override fun onBindViewHolder(holderPOI: POIViewHolder, position: Int) {
        val POI = mutablePOI[position]
        holderPOI.bind(POI = POI)
    }

    inner class POIViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var poiNameLabel: TextView = itemView.findViewById(R.id.poiName)
        private var poiDescriptionLabel: TextView = itemView.findViewById(R.id.poiDescription)
        private var poiRateLabel: TextView = itemView.findViewById(R.id.poiRate)
        private var poiPictureImg: ImageView = itemView.findViewById(R.id.poiPicture)
        private var poiLogoLocation: ImageView = itemView.findViewById(R.id.poiLogoLocation)
        private var currentPOI: POIsModels? = null

        init {
            itemView.setOnClickListener {
                currentPOI?.let {
                    onClick(it)
                }
            }
        }

        fun bind(POI: POIsModels) {
            currentPOI = POI
            poiNameLabel.text = POI.name
            poiDescriptionLabel.text = POI.description
            poiRateLabel.text = POI.rate

            Glide.with(context)
                .load(POI.picture)
                .into(poiPictureImg)

            poiLogoLocation.setOnClickListener{searchLocation()}

        }
        fun searchLocation() {
            val queryUrl: Uri = Uri.parse("geo:0,0?q=${currentPOI?.latitude},${currentPOI?.longitude}")
            val mapIntent = Intent(Intent.ACTION_VIEW, queryUrl)
            mapIntent.setPackage("com.google.android.apps.maps")
            context.startActivity(mapIntent)
        }
    }
}
