package `in`.indilabz.tikona.fragments


import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.activity.MainActivity
import `in`.indilabz.tikona.adapter.PaymentAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PaymentHistory : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_payment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<String>()
        list.add("123456789")
        list.add("123456789")
        list.add("123456789")
        list.add("123456789")
        list.add("123456789")
        list.add("123456789")
        list.add("123456789")
        list.add("123456789")
        list.add("123456789")
        list.add("123456789")

        val rcv= view.findViewById<RecyclerView>(R.id.payment_rcv)
        rcv.layoutManager = LinearLayoutManager(activity)

        val adapter = PaymentAdapter(list)
        rcv.adapter = adapter
        adapter.notifyDataSetChanged()

    }


}
