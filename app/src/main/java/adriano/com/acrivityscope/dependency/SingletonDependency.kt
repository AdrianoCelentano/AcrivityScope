package adriano.com.acrivityscope.dependency

import android.app.Application
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SingletonDependency @Inject constructor(application: Application) {

    companion object {
        var count : Int = 0
    }

    init {
        count++
        Log.d("scope", "Singleton ${count.toString()}")
    }

}
