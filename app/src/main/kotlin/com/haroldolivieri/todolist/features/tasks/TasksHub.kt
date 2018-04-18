package com.haroldolivieri.todolist.features.tasks

import io.fluent.*
import java.util.*
import javax.inject.Inject

class TasksHub
@Inject constructor(private val readTasksJob : TasksJob) : Hub<TasksView> {
    override fun connect(view: TasksView) {
        readTasksJob.run(Date())
    }

    override fun disconnect() {}
}



