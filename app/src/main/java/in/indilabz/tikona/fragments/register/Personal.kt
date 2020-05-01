package `in`.indilabz.tikona.fragments.register


import `in`.indilabz.tikona.R
import `in`.indilabz.tikona.activity.Register
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_personal.*

class Personal : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_personal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personal_back.setOnClickListener {
            (activity as Register).backButton()
        }

        personal_continue.setOnClickListener {
            (activity as Register).addFragment(2)
        }

        openRegister.setOnClickListener {
            (activity as Register).backToLogin()
        }

    }


}
