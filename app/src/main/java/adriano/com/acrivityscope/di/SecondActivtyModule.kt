package adriano.com.acrivityscope.di

import adriano.com.acrivityscope.android.MainActivity
import adriano.com.acrivityscope.android.SecondActivity
import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class SecondActivtyModule {

    @Provides
    @PerActivity
    fun provideActivity(secondActivity: SecondActivity) : Activity = secondActivity
}