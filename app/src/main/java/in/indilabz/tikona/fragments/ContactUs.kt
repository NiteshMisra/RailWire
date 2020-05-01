package `in`.indilabz.tikona.fragments

import `in`.indilabz.tikona.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class ContactUs : Fragment() {

    private lateinit var call : TextView
    private lateinit var email : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact_us, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        call = view.findViewById(R.id.call)
        email = view.findViewById(R.id.email)

        call.setOnClickListener {
            call()
        }

        email.setOnClickListener {
            mail()
        }
    }

    private fun call(){

        try{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = (Uri.parse("tel:+919999999999"))
            startActivity(intent)
        }
        catch (e : Exception){

            Toast.makeText(activity!!,"Unable to make phone calls!", Toast.LENGTH_LONG).show()
        }
    }

    private fun mail(){

        try {
            val  mail = Intent(Intent.ACTION_SEND)
            mail.type = "message/rfc822"
            mail.putExtra(Intent.EXTRA_EMAIL  , arrayOf("gg@gmail.com"))
            startActivity(Intent.createChooser(mail, "Send mail..."))
        }
        catch (e : Exception){
            Toast.makeText(activity!!,"Unable to open any email app, make sure you have one!",
                Toast.LENGTH_LONG).show()
        }
    }


}
