package `in`.indilabz.tikona.activity

import `in`.indilabz.tikona.INDIPreferences
import `in`.indilabz.tikona.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        openRegister.setOnClickListener {
            startActivity(Intent(this,Register::class.java))
        }

        forgotPassword.setOnClickListener {
            startActivity(Intent(this,ForgotPassword::class.java))
        }

        login.setOnClickListener {
            INDIPreferences.session(true)
            val intent =Intent(this,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
}
