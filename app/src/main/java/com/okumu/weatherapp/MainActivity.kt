package com.okumu.weatherapp

import android.app.Activity
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.okumu.weatherapp.databinding.ActivityMainBinding
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
//    val CITY: String = "Nai,bd"
//    val API:  String = "63b655b271bf78ff7f96e404032760a7"
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: WeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this). get(WeatherViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

    }
}

//        weatherTask().execute()
//    }
//
//    inner class weatherTask() : AsyncTask<String, Void, String>(){
//        override fun onPreExecute() {
//            super.onPreExecute()
//            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
//            findViewById<RelativeLayout>(R.id.errortext).visibility = View.GONE
//        }
//
//        override fun doInBackground(vararg params: String?): String? {
//            var response:String?
//            try {
//                response = URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API")
//                    .readText(Charsets.UTF_8)
//            } catch (e: Exception){
//                response = null
//            }
//            return response
//        }
//
//        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
//            try {
//                val jsonObj = JSONObject(result)
//                val main = jsonObj.getJSONObject("main")
//                val sys = jsonObj.getJSONObject("sys")
//                val wind = jsonObj.getJSONObject("wind")
//                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)
//                val updatedAt:Long = jsonObj.getLong("dt")
//                val updatedText = "Updated at: " + SimpleDateFormat("dd/MM/yy hh:mm a", Locale.English).format(
//                    Date(updatedAt*1000)
//                )
//            } catch (e: Exception){
//
//            }
//        }
//    }
//}

