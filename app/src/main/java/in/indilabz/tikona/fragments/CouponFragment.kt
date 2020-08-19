package `in`.indilabz.tikona.fragments

import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.activity.MainActivity
import `in`.indilabz.tikona.adapter.CouponAdapter
import `in`.indilabz.tikona.databinding.FragmentCouponBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager

class CouponFragment : Fragment() {

    private lateinit var binding :FragmentCouponBinding
    private lateinit var context : FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_coupon, container, false)
        context = requireActivity()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.couponRcv.layoutManager = LinearLayoutManager(context)
        val list : ArrayList<Int> = ArrayList()
        for (i in 0..5)
            list.add(i)

        val couponAdapter = CouponAdapter(list)
        binding.couponRcv.adapter = couponAdapter
        couponAdapter.notifyDataSetChanged()

        binding.proceedBtn.setOnClickListener {
            // if you have to pass something to the next fragment
            // then you can use sharedPreference for that
            (context as MainActivity).change(R.id.paymentOverviewFrag)
        }
    }
}