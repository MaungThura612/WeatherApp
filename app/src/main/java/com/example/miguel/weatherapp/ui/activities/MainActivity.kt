package com.example.miguel.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.example.miguel.weatherapp.R
import com.example.miguel.weatherapp.domain.commands.RequestForecastCommand
import com.example.miguel.weatherapp.domain.model.ForecastList
import com.example.miguel.weatherapp.extensions.DelegatesExt
import com.example.miguel.weatherapp.ui.ToolbarManger
import com.example.miguel.weatherapp.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.asReference
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), ToolbarManger {

    override val toolbar: Toolbar by lazy  {find<Toolbar>(R.id.toolbar)}
    val zipCode: Long by DelegatesExt.preference(this, SettingsActivity.ZIP_CODE, SettingsActivity.DEFAULT_ZIP)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)


    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() =  async(UI) {
        val result = bg { RequestForecastCommand(zipCode).execute() }
        updateUI(result.await())

    }

    private fun updateUI(result: ForecastList) {
        val adapter = ForecastListAdapter(result) {
            startActivity<DetailActivity>(DetailActivity.ID to it.id,
                    DetailActivity.CITY_NAME to result.city)
        }
        forecastList.adapter = adapter

        toolbarTitle = "${result.city} (${result.country})"
    }
}
