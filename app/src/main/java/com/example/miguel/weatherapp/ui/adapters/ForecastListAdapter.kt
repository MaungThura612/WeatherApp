package com.example.miguel.weatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.miguel.weatherapp.R
import com.example.miguel.weatherapp.domain.model.Forecast
import com.example.miguel.weatherapp.domain.model.ForecastList
import com.example.miguel.weatherapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 *
 * Created by Miguel on 21/10/2017.
 *
 */
class ForecastListAdapter(private val weekForecast : ForecastList, private val itemClick: ForecastListAdapter.OnItemClickListener) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view,itemClick)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
             holder.bindForecast(weekForecast[position])
    }

     override fun getItemCount(): Int = weekForecast.size

     class ViewHolder(view: View, private val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {

         val iconView = view.find<ImageView>(R.id.icon)
         val dateView = view.find<TextView>(R.id.date)
         val descriptionView = view.find<TextView>(R.id.description)
         val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
         val minTemperatureView = view.find<TextView>(R.id.minTemperature)
         fun bindForecast(forecast: Forecast) { with(forecast) {
             Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
             dateView.text = date
                     descriptionView.text = description
             maxTemperatureView.text = "$high"
             minTemperatureView.text = "$low"
             itemView.setOnClickListener { itemClick(this) }
         } }

     }

    interface OnItemClickListener{
        operator fun invoke(forecast: Forecast)
    }
}