package stsfan.com.kotlinstu.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this@MyApp)
    }
}