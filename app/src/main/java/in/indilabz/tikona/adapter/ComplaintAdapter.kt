package `in`.indilabz.tikona.adapter

import `in`.indilabz.tikona.R
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComplaintAdapter(var list: ArrayList<Boolean>) : RecyclerView.Adapter<ComplaintAdapter.ComplaintHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComplaintHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_complaint,parent,false)
        return ComplaintHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ComplaintHolder, position: Int) {
        if (list[position]){
            holder.received.text = ("Resolved")
            holder.received.setBackgroundResource(R.drawable.resolved_background)
            holder.received.setTextColor(Color.parseColor("#191654"))
        }else{
            holder.received.text = ("Received")
            holder.received.setBackgroundResource(R.drawable.received_background)
            holder.received.setTextColor(Color.parseColor("#43c6ac"))
        }
    }

    class ComplaintHolder(view: View) : RecyclerView.ViewHolder(view){
        val received : TextView = view.findViewById(R.id.complaint_received)
    }
}