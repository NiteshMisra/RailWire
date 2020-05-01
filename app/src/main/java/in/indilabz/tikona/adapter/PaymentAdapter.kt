package `in`.indilabz.tikona.adapter

import `in`.indilabz.tikona.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PaymentAdapter(var list : ArrayList<String>) : RecyclerView.Adapter<PaymentAdapter.PaymentHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_payment_history,parent,false)
        return PaymentHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PaymentHolder, position: Int) {
        holder.id.text = ("Transaction Id : ${list[position]}")
    }


    class PaymentHolder(view : View) : RecyclerView.ViewHolder(view){
        val id : TextView = view.findViewById(R.id.trans_id)
    }

}