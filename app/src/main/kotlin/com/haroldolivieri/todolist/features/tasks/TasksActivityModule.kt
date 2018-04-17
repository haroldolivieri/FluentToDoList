package com.haroldolivieri.todolist.features.tasks

import dagger.Module
import dagger.Provides
import io.fluent.Job
import io.fluent.Store
import java.util.*

@Module
class TasksActivityModule {

    @Provides
    fun provideTaskStore() : Store<TasksState> = TasksStore(TasksState())

    @Provides
    fun provideReadFromDatabaseJob(taskStore: Store<TasksState>) : Job<Date> =
            ReadJobsFromDatabase(taskStore)

}