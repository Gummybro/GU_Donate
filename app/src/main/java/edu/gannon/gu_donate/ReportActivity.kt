package edu.gannon.gu_donate

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val reportTextView = findViewById<TextView>(R.id.reportText)
        val backButton = findViewById<Button>(R.id.backButton)

        // Load donation data from SharedPreferences
        val sharedPreferences = getSharedPreferences("DonationData", Context.MODE_PRIVATE)
        val donations = sharedPreferences.getString("donations", "No donations made yet.")
        reportTextView.text = "Donations Report:\n$donations"

        // Back button to return to DonateActivity
        backButton.setOnClickListener {
            finish()  // Closes report screen and returns to donation screen
        }
    }
}
