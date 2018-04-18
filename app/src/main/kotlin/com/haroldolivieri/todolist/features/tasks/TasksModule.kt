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
    fun provideStore(): Store<TasksState> = TasksStore(TasksState())

    @Provides
    fun provideJob(store: Store<TasksState>) : Job<Date> = TasksJob(store)

    @Provides
    fun provideTaskHub(taskJob: Job<@JvmSuppressWildcards Date>) : Hub<TasksView> = TasksHub(taskJob)
}