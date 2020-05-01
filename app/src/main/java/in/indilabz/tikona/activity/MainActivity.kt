package `in`.indilabz.tikona.activity

import `in`.indilabz.tikona.INDIPreferences
import `in`.indilabz.tikona.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        if (INDIPreferences.firstTime()){
            val builder = AlertDialog.Builder(this)
            val view = LayoutInflater.from(this).inflate(R.layout.home_dialog,null,false)
            builder.setView(view)
            val ok : TextView = view.findViewById(R.id.ok)
            val dialog = builder.create()
            dialog.setCanceledOnTouchOutside(false)
            ok.setOnClickListener {
                INDIPreferences.firstTime(false)
                dialog.dismiss()
            }
            dialog.show()
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment,
                R.id.accountFragment,
                R.id.profileFragment,
                R.id.billFragment,
                R.id.myRequestFragment),
            drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.nav_logOut -> {
                    logout()
                }

                else -> {
                    val int = when (it.itemId) {
                        R.id.nav_home     -> (R.id.homeFragment)
                        R.id.nav_acc_inf    -> (R.id.accountFragment)

                        else -> R.id.homeFragment
                    }
                    drawerLayout.closeDrawer(navView)
                    change(int)
                }
            }
        }

        navView.menu.getItem(0).isChecked = true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun change(destination: Int): Boolean{

        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(destination)
        return true
    }

    private fun logout(): Boolean {
        INDIPreferences.session(false)
        val intent = Intent(this,Login::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.notification, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.nav_notify){
            startActivity(Intent(this,Notifications::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

}
