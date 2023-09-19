package com.example.p6_ppapb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.p6_ppapb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countries = arrayOf(
            "Indonesia",
            "Malaysia",
            "Brunei",
            "Filipina",
            "Timor Leste"
        )

        val cities = resources.getStringArray(R.array.cities)
        with(binding){
            val countriesAdapter = ArrayAdapter(this@MainActivity,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, countries)

            countriesAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

            spinCountries.adapter = countriesAdapter

            val citiesAdapter = ArrayAdapter(this@MainActivity,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, cities)

            citiesAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

            spinCities.adapter = citiesAdapter

            var selectDate = ""
            datePick.init(datePick.year, datePick.month, datePick.dayOfMonth) {
                _, year, month, day ->
                selectDate = "$day/${month+1}/$year "
                Toast.makeText(this@MainActivity,selectDate, Toast.LENGTH_SHORT).show()
            }

            var selectTime = ""
            timePicker.setOnTimeChangedListener{timePicker, hourofDay, minutes ->
                selectTime = String.format("%02d:%02d", hourofDay, minutes)
                Toast.makeText(this@MainActivity, selectTime, Toast.LENGTH_SHORT).show()
            }
        }
    }
}