package `in`.indilabz.tikona.activity

import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.fragments.password.ForgotOTP
import `in`.indilabz.tikona.fragments.password.ForgotPassword
import `in`.indilabz.tikona.fragments.register.Address
import `in`.indilabz.tikona.fragments.register.OTP
import `in`.indilabz.tikona.fragments.register.Personal
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class ForgotPassword : AppCompatActivity() {

    private lateinit var fragmentManager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.forgot_container, ForgotPassword())
            .commit()
    }

    fun addFragment(){
        fragmentManager.beginTransaction()
            .replace(R.id.forgot_container, ForgotOTP())
            .addToBackStack("FragmentTag")
            .commit()
    }

    fun backButton(){
        if (fragmentManager.backStackEntryCount > 1){
            fragmentManager.popBackStack()
        }else{
            onBackPressed()
        }
    }
}
