package com.example.maweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.maweather.databinding.ActivityMainBinding
import com.example.maweather.fragments.MainFragment
import com.example.maweather.utils.Constants.Companion.API_KEY
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        supportFragmentManager.beginTransaction().replace(R.id.placeHolder, MainFragment.newInstance()).commit()

        setContentView(binding.root)
        binding.bGet.setOnClickListener{
            getResult("London")
        }
    }
    private fun getResult(name : String){
        val url = ("http://api.weatherapi.com/v1/current.json" +
                "?key=$API_KEY&q=$name&aqi=no")

        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {response->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("current")
                Log.d("My log", "Volley error: ${temp.getString("temp_c")}")
            },
            {
                Log.d("My log", "Volley error: $it")
            }
        )
        queue.add(stringRequest)
    }
}