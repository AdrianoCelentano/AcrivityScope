package adriano.com.acrivityscope.di

import dagger.Module
import adriano.com.acrivityscope.android.MainActivity
import adriano.com.acrivityscope.dependency.ActivityDependencyModule
import adriano.com.acrivityscope.dependency.SingletonDependency
import android.app.Activity
import dagger.Provides



@Module
class MainActivtyModule {

    @Provides
    @PerActivity
    fun provideActivity(mainActivity: MainActivity) : Activity = mainActivity

    @Provides
    @PerActivity
    fun provideActivityDependency(singletonDependency: SingletonDependency, activity: Activity) : ActivityDependencyModule {
        return ActivityDependencyModule(singletonDependency, activity)
    }
}
