@file:Suppress("DEPRECATION")

package `in`.indilabz.tikona.empActivity

import `in`.indilabz.tikona.INDIPreferences
import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.activity.Login
import `in`.indilabz.tikona.adapter.ComplaintAdapter2
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.*
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_emp_main.*

class EmpMainActivity : AppCompatActivity() {

    lateinit var sliderLayout: ViewPager
    private var countDownTimer: CountDownTimer?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emp_main)
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        sliderLayout = findViewById(R.id.imageSlider)

        val adapter = ViewPagerAdapter(this)
        sliderLayout.adapter = adapter

        sliderLayout.setPadding(20,0,130,0)
        sliderLayout.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
                startTimer()
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                startTimer()
            }

            override fun onPageSelected(position: Int) {
                Log.e("log","onPageSelected")
            }

        })

        startTimer()

        user_register.setOnClickListener {
            startActivity(Intent(this,UserRegistration::class.java))
        }

        val recyclerView : RecyclerView = findViewById(R.id.complaint_rcv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val list : ArrayList<String> = ArrayList()
        list.add("Heading1")
        list.add("Heading2")
        list.add("Heading3")
        list.add("Heading4")
        list.add("Heading5")
        list.add("Heading6")
        list.add("Heading7")
        list.add("Heading8")
        list.add("Heading9")
        list.add("Heading10")
        list.add("Heading11")
        list.add("Heading12")
        list.add("Heading13")

        val cAdapter = ComplaintAdapter2(list,this)
        recyclerView.adapter = cAdapter
        cAdapter.notifyDataSetChanged()
    }

    fun startTimer(){

        if (countDownTimer != null){
            countDownTimer!!.cancel()
        }

        countDownTimer  = object : CountDownTimer(8000,1000){
            override fun onFinish() {
                when(sliderLayout.currentItem){
                    0 -> {
                        sliderLayout.currentItem = 1
                    }
                    1 -> {
                        sliderLayout.currentItem = 2
                    }
                    2 -> {
                        sliderLayout.currentItem = 0
                    }
                }
            }

            override fun onTick(millisUntilFinished: Long) {

            }

        }
        countDownTimer!!.start()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.nav_log_out){
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Are you sure you want to LogOut ??")
            builder.setTitle("Log Out")
            builder.setPositiveButton("LogOut"
            ) { dialog, _ ->
                INDIPreferences.session(false)
                dialog.dismiss()
                val intent = Intent(this, Login::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            builder.setNegativeButton("Cancel"){
                    dialog, _ ->
                dialog.dismiss()
            }
            val alertDialog = builder.create()
            alertDialog.show()

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(countDownTimer != null){
            countDownTimer!!.cancel()
        }
    }

}

class ViewPagerAdapter(var context: Context) : PagerAdapter() {

    private var images: Array<Int> = arrayOf(
        R.drawable.plans,
        R.drawable.invite,
        R.drawable.support
    )
    private lateinit var layoutInflater: LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.slider_card, null)
        val image: ImageView = view.findViewById(R.id.slider_image)
        image.setImageResource(images[position])

        val viewPager = container as ViewPager
        viewPager.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }

}
