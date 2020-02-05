package com.visual.flickerdemo;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {AndroidInjectionModule.class, DemoApplicationModule.class})
interface DemoApplicationComponent extends AndroidInjector<DemoApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<DemoApplication>{

    }
}