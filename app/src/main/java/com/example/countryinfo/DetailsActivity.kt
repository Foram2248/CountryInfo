package com.example.countryinfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {

    private lateinit var countryNameTextView: TextView
    private lateinit var capitalTextView: TextView
    private lateinit var populationTextView: TextView

    private val countryInfo = mapOf(
        "USA" to CountryInfo("USA", "Washington, D.C.", "331 million"),
        "Canada" to CountryInfo("Canada", "Ottawa", "38 million"),
        "Mexico" to CountryInfo("Mexico", "Mexico City", "128 million"),
        "Brazil" to CountryInfo("Brazil", "Brasília", "213 million"),
        "UK" to CountryInfo("UK", "London", "67 million")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        countryNameTextView = findViewById(R.id.countryNameTextView)
        capitalTextView = findViewById(R.id.capitalTextView)
        populationTextView = findViewById(R.id.populationTextView)

        val selectedCountry = intent.getStringExtra("country")
        if (selectedCountry != null) {
            supportActionBar?.title = selectedCountry
            val info = countryInfo[selectedCountry]
            if (info != null) {
                countryNameTextView.text = "Country: ${info.name}"
                capitalTextView.text = "Capital: ${info.capital}"
                populationTextView.text = "Population: ${info.population}"
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

data class CountryInfo(val name: String, val capital: String, val population: String)
