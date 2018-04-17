package com.haroldolivieri.todolist.features.tasks

import io.fluent.Job
import io.fluent.StateType
import io.fluent.Store
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import java.util.*
import javax.inject.Inject

class TasksJob
@Inject constructor(private val taskStore: Store<TasksState>) : Job<Date> {
    override fun run(input: Date) {
        //read tasks from database
        launch {
            delay(3000)
            taskStore.update(taskStore.state().setType(StateType.Initial))
        }
    }
}