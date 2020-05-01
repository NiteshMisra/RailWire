package `in`.indilabz.tikona.fragments


import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.activity.MainActivity
import `in`.indilabz.tikona.adapter.ComplaintAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ComplaintHistory : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_complaint_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView = view.findViewById(R.id.complaint_rcv)
        recyclerView.layoutManager = LinearLayoutManager(activity!!)

        val list : ArrayList<Boolean> = ArrayList()
        list.add(true)
        list.add(false)
        list.add(false)
        list.add(false)
        list.add(true)
        list.add(true)
        list.add(true)
        list.add(false)
        list.add(true)
        list.add(false)
        list.add(true)

        val adapter = ComplaintAdapter(list)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }
}
