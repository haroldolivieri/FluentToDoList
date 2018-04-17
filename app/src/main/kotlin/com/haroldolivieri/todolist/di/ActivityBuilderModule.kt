package com.haroldolivieri.todolist.di

import com.haroldolivieri.todolist.features.tasks.TasksListActivity
import com.haroldolivieri.todolist.features.tasks.TasksModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = arrayOf(TasksModule::class))
    internal abstract fun bindMainActivity(): TasksListActivity
}