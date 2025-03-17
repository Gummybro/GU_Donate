package edu.gannon.gu_donate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private var loginAttempts = 3
    private val validUsername = "admin"
    private val validPassword = "ANIK001"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameInput = findViewById<EditText>(R.id.username)
        val passwordInput = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val errorMessage = findViewById<TextView>(R.id.errorMessage)
        val contactInfo = findViewById<TextView>(R.id.contactUs)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (username == validUsername && password == validPassword) {
                startActivity(Intent(this, DonateActivity::class.java))
                finish()
            } else {
                loginAttempts--
                errorMessage.text = "Invalid Credentials! Attempts left: $loginAttempts"
                if (loginAttempts == 0) {
                    loginButton.isEnabled = false
                    errorMessage.text = "Account Locked!"
                }
            }
        }

        contactInfo.setOnClickListener {
            Toast.makeText(this, "Made by: ANIK001", Toast.LENGTH_LONG).show()
        }
    }
}
