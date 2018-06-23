package adriano.com.acrivityscope.android

import adriano.com.acrivityscope.R
import adriano.com.acrivityscope.dependency.ActivityDependencyContructor
import adriano.com.acrivityscope.dependency.NoScopeDependency
import adriano.com.acrivityscope.dependency.SingletonDependency
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.Lazy
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var activityDependencyContructor: ActivityDependencyContructor

    @Inject
    lateinit var singletonDependency: SingletonDependency

    @Inject
    lateinit var noScopeDependency: NoScopeDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}

class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var activityDependencyContructor: ActivityDependencyContructor

    @Inject
    lateinit var singletonDependency: SingletonDependency

    @Inject
    lateinit var noScopeDependency: NoScopeDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
