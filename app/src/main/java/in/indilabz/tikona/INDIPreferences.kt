package `in`.indilabz.tikona

import android.app.Activity
import android.content.SharedPreferences


class INDIPreferences  {

    companion object {

        private val preferences: SharedPreferences
            get() = INDIMaster.applicationContext().getSharedPreferences("RailWire", Activity.MODE_PRIVATE)

        fun preferenceEditor(): SharedPreferences.Editor {
            return INDIMaster.applicationContext().getSharedPreferences("RailWire", Activity.MODE_PRIVATE).edit()
        }

        //// Add following lines to store and retrieve String

        fun session(value: Boolean) {
            val editor = preferences.edit()
            editor.putBoolean("APP_SESSION", value)
            editor.commit()
        }

        fun session(): Boolean {
            val mSharedPreferences = preferences
            return mSharedPreferences.getBoolean("APP_SESSION", false)
        }

        fun firstTime(value: Boolean) {
            val editor = preferences.edit()
            editor.putBoolean("APP_FIRST_TIME", value)
            editor.commit()
        }

        fun firstTime(): Boolean {
            val mSharedPreferences = preferences
            return mSharedPreferences.getBoolean("APP_FIRST_TIME", false)
        }
    }
}