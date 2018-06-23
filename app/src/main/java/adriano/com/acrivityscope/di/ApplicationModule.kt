package adriano.com.acrivityscope.di

import adriano.com.acrivityscope.android.MainActivity
import adriano.com.acrivityscope.android.SecondActivity
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import javax.inject.Inject
import javax.inject.Scope


@Module(includes = [AndroidInjectionModule::class])
abstract class ApplicationModule() {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivtyModule::class])
    internal abstract fun MainActivityInjector(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [SecondActivtyModule::class])
    internal abstract fun SecondActivityInjector(): SecondActivity

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

// The standard scope is @Singleton. Users of singleton-scoped bindings all get the same instance.

// In Dagger, a component can be associated with a scope by annotating it with a @Scope annotation.
// In that case, the component implementation holds references to all scoped objects so they can be reused.
// Modules with @Provides methods annotated with a scope may only be installed into a component annotated with the same scope.

// Types with @Inject constructors may also be annotated with scope annotations.
// These “implicit bindings” may be used by any component annotated with that scope or any of its descendant components.
// The scoped instance will be bound in the correct scope.

//No subcomponent may be associated with the same scope as any ancestor component

//The two subcomponents effectively have different scope instances even if they use the same scope annotation


//Components keep scoped instances, Modules / Constructors provide information to create Factories
//for field injection component needs `inject(target)` method, to set the field of the target by the instance provided from the component, which can be created by the factory or scoped and so allready instantieted
//AndroidInjectors make sure the right Component gets injected in the Activity + handle the lifecycle of the Component to be scoped to the actvity lifecycle
// @ContributesAndroidInjector provides a Subcomponent + AndroidInjector for an Activity, Fragment , ...