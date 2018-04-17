package com.haroldolivieri.todolist.features.tasks

import dagger.Module
import dagger.Provides
import io.fluent.Hub
import io.fluent.Job
import io.fluent.Store
import java.util.*

@Module
class TasksModule {
    @Provides
    fun provideView(activity: TasksListActivity) : TasksView = activity

    @Provides
    fun provideReadFromDatabaseJob(taskStore: Store<TasksState>) : Job<Date> = TasksJob(taskStore)

    @Provides
    fun provideTaskHub(taskJob: Job<Date>) : Hub<TasksView> = TasksHub(taskJob)
}