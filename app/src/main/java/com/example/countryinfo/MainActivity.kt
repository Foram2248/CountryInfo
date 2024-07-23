package com.example.countryinfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var countrySpinner: Spinner
    private lateinit var viewInfoButton: Button

    private val countries = arrayOf("USA", "Canada", "Mexico", "Brazil", "UK")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countrySpinner = findViewById(R.id.countrySpinner)
        viewInfoButton = findViewById(R.id.viewInfoButton)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countrySpinner.adapter = adapter

        countrySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Do something when an item is selected
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do something when nothing is selected
            }
        }

        viewInfoButton.setOnClickListener {
            val selectedCountry = countrySpinner.selectedItem.toString()
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("country", selectedCountry)
            startActivity(intent)
        }
    }
}
