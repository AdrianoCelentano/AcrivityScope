package adriano.com.acrivityscope.dependency

import adriano.com.acrivityscope.android.MainActivity
import adriano.com.acrivityscope.di.PerActivity
import android.app.Activity
import android.util.Log
import javax.inject.Inject

class ActivityDependencyModule constructor(singletonDependency: SingletonDependency, activity: Activity) {

    companion object {
        var count : Int = 0
    }

    init {
        count++
        Log.d("scope", "activity ${count.toString()}")
    }
}