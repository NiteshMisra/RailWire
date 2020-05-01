@file:Suppress("DEPRECATION")

package `in`.indilabz.tikona.fragments.main

import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.activity.MainActivity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class Home : Fragment() {

    lateinit var sliderLayout: ViewPager
    private var countDownTimer: CountDownTimer ?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sliderLayout = view.findViewById(R.id.imageSlider)

        val adapter = ViewPagerAdapter(activity!!)
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

        val complaintService: CardView = view.findViewById(R.id.complaint_service)
        complaintService.setOnClickListener {
            (activity as MainActivity).change(R.id.serviceFragment)
        }

        val billPay: CardView = view.findViewById(R.id.bill_pay)
        billPay.setOnClickListener {
            (activity as MainActivity).change(R.id.billPayFragment)
        }

        val refer: CardView = view.findViewById(R.id.refer_earn)
        refer.setOnClickListener {
            (activity as MainActivity).change(R.id.referFragment)
        }

        val payHistory: CardView = view.findViewById(R.id.payment_history)
        payHistory.setOnClickListener {
            (activity as MainActivity).change(R.id.paymentHisFragment)
        }

        val comHistory: CardView = view.findViewById(R.id.complaint_history)
        comHistory.setOnClickListener {
            (activity as MainActivity).change(R.id.complaintHisFragment)
        }

        val support : CardView = view.findViewById(R.id.support)
        support.setOnClickListener {
            (activity as MainActivity).change(R.id.contactUsFragment)
        }

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
