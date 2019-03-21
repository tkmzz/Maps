package br.com.luiz.maps

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_map_by_intent.*

class MapByIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_by_intent)

        btExibirLocal.setOnClickListener{
            val latitudelongitude = "-23.5565804, -46.662113"
            val zoom = 15
            val geo = "geo:$latitudelongitude?z=$zoom"
            showOnMap(geo)
        }

        btShowRestaurants.setOnClickListener {
            val query = "restaurantes"
            val geo = "geo:0,0?q=$query"
            showOnMap(geo)
        }

        btShowRoute.setOnClickListener {
            val address = "Rua Olimpiadas, 186, São Paulo, São Paulo, Brasil"
            val location = Uri.encode(address)
            val modo = "w"
            val geo = "google.navigation:q=$location&mode=$modo"
            showOnMap(geo)
        }
    }

    fun showOnMap(geo: String){
        val geoURI = Uri.parse(geo)
        val intent = Intent(Intent.ACTION_VIEW, geoURI)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }
}
