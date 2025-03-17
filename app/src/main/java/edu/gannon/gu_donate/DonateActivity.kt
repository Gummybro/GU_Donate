package edu.gannon.gu_donate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DonateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)

        val amountInput = findViewById<EditText>(R.id.amount)
        val paymentTypeGroup = findViewById<RadioGroup>(R.id.paymentTypeGroup)
        val donateButton = findViewById<Button>(R.id.donateButton)
        val reportButton = findViewById<Button>(R.id.reportButton)

        donateButton.setOnClickListener {
            val amount = amountInput.text.toString().toDoubleOrNull()
            val selectedMethodId = paymentTypeGroup.checkedRadioButtonId

            if (amount != null && selectedMethodId != -1) {
                val paymentMethod = findViewById<RadioButton>(selectedMethodId).text.toString()

                // Save the donation to SharedPreferences
                val sharedPreferences = getSharedPreferences("DonationData", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()

                val oldDonations = sharedPreferences.getString("donations", "") ?: ""
                val newDonation = "- $$amount via $paymentMethod\n"
                editor.putString("donations", oldDonations + newDonation)
                editor.apply()

                Toast.makeText(this, "Thank you for your donation!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Enter valid amount and payment method", Toast.LENGTH_SHORT).show()
            }
        }

        reportButton.setOnClickListener {
            startActivity(Intent(this, ReportActivity::class.java))
        }
    }
}
