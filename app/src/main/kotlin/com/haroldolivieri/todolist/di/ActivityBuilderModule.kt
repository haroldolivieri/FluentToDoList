package com.haroldolivieri.todolist.di

import com.haroldolivieri.todolist.features.main.MainActivity
import com.haroldolivieri.todolist.features.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    internal abstract fun bindMainActivity(): MainActivity
}