package adriano.com.acrivityscope.dependency

import android.util.Log
import javax.inject.Inject

class NoScopeDependency @Inject constructor(singletonDependency: SingletonDependency, activityDependency: ActivityDependencyContructor) {

    companion object {
        var count : Int = 0
    }

    init {
        count++
        Log.d("scope", "noScope ${count.toString()}")
    }

}
