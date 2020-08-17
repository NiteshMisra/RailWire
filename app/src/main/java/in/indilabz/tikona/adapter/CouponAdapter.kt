package `in`.indilabz.tikona.adapter

import `in`.indilabz.tikona.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CouponAdapter(var list : ArrayList<Int>) : RecyclerView.Adapter<CouponAdapter.CouponHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_coupon,parent,false)
        return CouponHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CouponHolder, position: Int) {
        holder.couponCode.text = ("LUCKYUPI")
    }


    class CouponHolder(view : View) : RecyclerView.ViewHolder(view){
        val couponCode : TextView = view.findViewById(R.id.coupon_code)
    }

}