package com.haroldolivieri.todolist.di

import com.haroldolivieri.todolist.features.tasks.TasksListActivity
import com.haroldolivieri.todolist.features.tasks.TasksModule
import com.haroldolivieri.todolist.features.tasks.fragment.TasksFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [TasksModule::class, TasksFragmentProvider::class])
    internal abstract fun bindTaskActivity(): TasksListActivity
}