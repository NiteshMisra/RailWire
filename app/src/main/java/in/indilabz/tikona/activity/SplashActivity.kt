package `in`.indilabz.tikona.activity

import `in`.indilabz.tikona.INDIPreferences
import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.databinding.ActivitySplashBinding
import `in`.indilabz.tikona.empActivity.EmpMainActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil

class SplashActivity : AppCompatActivity() {
    
    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash)

        Handler().postDelayed({
            if (INDIPreferences.session()){
                if (INDIPreferences.isUser()){
                    INDIPreferences.session(true)
                    val intent =Intent(this,MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                }else{
                    INDIPreferences.session(true)
                    val intent =Intent(this, EmpMainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                }
            }else{
                val intent = Intent(this@SplashActivity,Login::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        },3000)
    }
}
