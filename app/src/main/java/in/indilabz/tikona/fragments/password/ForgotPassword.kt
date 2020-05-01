package `in`.indilabz.tikona.fragments.password


import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.activity.ForgotPassword
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_forgot_password.*

class ForgotPassword : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_forgot_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        forgotBack.setOnClickListener {
            (activity as ForgotPassword).backButton()
        }

        forgot_sendOTP.setOnClickListener {
            (activity as ForgotPassword).addFragment()
        }
    }


}
