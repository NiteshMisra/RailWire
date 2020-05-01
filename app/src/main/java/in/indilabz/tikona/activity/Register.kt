package `in`.indilabz.tikona.activity

import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.fragments.register.Address
import `in`.indilabz.tikona.fragments.register.OTP
import `in`.indilabz.tikona.fragments.register.Personal
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class Register : AppCompatActivity() {

    private lateinit var fragmentManager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.register_container,Personal())
            .commit()
    }

    fun backToLogin() {
        onBackPressed()
    }

    fun addFragment(pos : Int){
        if (pos == 2){
            fragmentManager.beginTransaction()
                .replace(R.id.register_container,Address())
                .addToBackStack("FragmentTag")
                .commit()
        }else if (pos == 3){
            fragmentManager.beginTransaction()
                .replace(R.id.register_container,OTP())
                .addToBackStack("FragmentTag")
                .commit()
        }
    }

    fun backButton(){
        if (fragmentManager.backStackEntryCount > 1){
            fragmentManager.popBackStack()
        }else{
            onBackPressed()
        }
    }
}
