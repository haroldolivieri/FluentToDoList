package com.haroldolivieri.todolist

import com.haroldolivieri.todolist.di.ApplicationComponent
import com.haroldolivieri.todolist.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class ToDoListApplication : DaggerApplication() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        applicationComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build()

        applicationComponent.inject(this)
        return applicationComponent
    }
}