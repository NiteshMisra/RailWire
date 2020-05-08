package `in`.indilabz.tikona.fragments

import `in`.indilabz.tikona.R
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

class UserRegisterTwo : Fragment() {

    private lateinit var datePicker: ImageView
    private lateinit var mDateSetListener: DatePickerDialog.OnDateSetListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_register_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datePicker = view.findViewById(R.id.date_picker)

        datePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year: Int = calendar.get(Calendar.YEAR)
            val month: Int = calendar.get(Calendar.MONTH)
            val day: Int = calendar.get(Calendar.DAY_OF_MONTH)

            val dialog = DatePickerDialog(requireActivity(), mDateSetListener, year, month, day)
            dialog.show()
        }

        mDateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            Toast.makeText(requireActivity(), "$dayOfMonth:${month + 1}:$year", Toast.LENGTH_LONG).show()
        }
    }


}
