package `in`.indilabz.tikona.fragments


import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.activity.MainActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_bill_pay.*

class BillPay : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bill_pay, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        payOnlineBtn.setOnClickListener {
            (requireActivity() as MainActivity).change(R.id.couponFragment)
        }
    }



}
