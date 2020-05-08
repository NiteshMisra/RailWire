package `in`.indilabz.tikona.empActivity

import `in`.indilabz.tikona.fragments.UserRegisterOne
import `in`.indilabz.tikona.fragments.UserRegisterTwo
import `in`.indilabz.tikona.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager

class UserRegistration : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_registration)
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.user_res_container, UserRegisterOne())
            .commit()

    }

    fun addFragment(){
        fragmentManager.beginTransaction()
            .replace(R.id.user_res_container, UserRegisterTwo())
            .addToBackStack("Tag")
            .commit()
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 1){
            fragmentManager.popBackStack()
        }else{
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}
