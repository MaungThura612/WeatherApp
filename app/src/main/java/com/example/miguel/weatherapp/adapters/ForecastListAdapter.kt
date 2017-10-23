package com.example.miguel.weatherapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 *
 * Created by Miguel on 21/10/2017.
 *
 */
class ForecastListAdapter(private val items : List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(TextView(parent.context))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.textView.text = items[position]
    }

     override fun getItemCount(): Int = items.size

     class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}