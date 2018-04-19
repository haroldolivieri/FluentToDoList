package com.haroldolivieri.todolist.features.tasks.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TasksFragmentProvider {
    @ContributesAndroidInjector(modules = [(TasksFragmentModule::class)])
    internal abstract fun bindMainActivity(): TasksFragment
}