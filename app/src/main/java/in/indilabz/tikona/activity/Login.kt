package `in`.indilabz.tikona.activity

import `in`.indilabz.tikona.INDIPreferences
import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.databinding.ActivityLoginBinding
import `in`.indilabz.tikona.empActivity.EmpMainActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayout

class Login : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        tabChange()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(binding.tabLayout.selectedTabPosition){
                    0 -> {
                        INDIPreferences.isUser(true)
                        tabChange()
                    }
                    1 -> {
                        INDIPreferences.isUser(false)
                        tabChange()
                    }
                }
            }

        })

        binding.openRegister.setOnClickListener {
            startActivity(Intent(this,Register::class.java))
        }

        binding.forgotPassword.setOnClickListener {
            startActivity(Intent(this,ForgotPassword::class.java))
        }

        binding.login.setOnClickListener {
            if (INDIPreferences.isUser()){
                INDIPreferences.session(true)
                val intent =Intent(this,MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }else{
                INDIPreferences.session(true)
                val intent =Intent(this,EmpMainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }
    }

    private fun tabChange() {
        if (INDIPreferences.isUser()){
            binding.tabLayout.getTabAt(0)!!.select()
            binding.userId.visibility = View.VISIBLE
            binding.v4.visibility = View.VISIBLE
            binding.username.hint = ("Username/Email Id/Mobile No.")
            binding.username.setPadding(0,10,0,10)
            binding.openRegister.visibility = View.VISIBLE
        }else{
            binding.tabLayout.getTabAt(1)!!.select()
            binding.userId.visibility = View.GONE
            binding.v4.visibility = View.GONE
            binding.username.setPadding(0,60,0,10)
            binding.username.hint = ("Username")
            binding.openRegister.visibility = View.GONE
        }
    }
}
