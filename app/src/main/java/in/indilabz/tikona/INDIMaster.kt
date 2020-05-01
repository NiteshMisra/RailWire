package `in`.indilabz.tikona

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.request.RequestOptions
import com.google.gson.GsonBuilder
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.util.*

class INDIMaster : Application(){

    var context: Context? = null


    override fun onCreate() {
        super.onCreate()
        instance = this@INDIMaster
        //CrashReporter.initialize(this)
        //ACRA.init(this);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        context = this.baseContext

    }

    companion object {

        @get:Synchronized
        var instance: INDIMaster? = null
            private set

        fun applicationContext() : INDIMaster {
            return instance!!.applicationContext as INDIMaster
        }
    }
}