package `in`.indilabz.tikona.fragments.register


import `in`.indilabz.tikona.INDIPreferences
import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.activity.MainActivity
import `in`.indilabz.tikona.activity.Register
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_otp.*

class OTP : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_otp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        otpBack.setOnClickListener {
            (activity as Register).backButton()
        }

        otpSubmit.setOnClickListener {
            INDIPreferences.firstTime(true)
            INDIPreferences.session(true)
            val intent = Intent(activity!!,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        openRegister.setOnClickListener {
            (activity as Register).backToLogin()
        }
    }


}
