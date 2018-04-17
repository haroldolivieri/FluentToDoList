package com.haroldolivieri.todolist.features.tasks

import io.fluent.*
import java.util.*
import javax.inject.Inject

interface TasksView: View<TasksState>

class TasksHub
@Inject constructor(private val readTasks : Job<Date>) : Hub<TasksView> {
    override fun connect(view: TasksView) {
        readTasks.run(Date())
    }

    override fun disconnect() {}
}

data class TasksState(val type: StateType = StateType.Loading) : State {
    override fun type() = type
    fun setType(newType: StateType) = copy(type = newType)
}

class ReadJobsFromDatabase
@Inject constructor(private val taskStore: Store<TasksState>) : Job<Date> {
    override fun run(input: Date) {
        //read tasks from database
        taskStore.update(taskStore.state().setType(StateType.Initial))
    }
}

class TasksStore(initialState: TasksState) : Store<TasksState>{
    private var currentState = initialState

    override fun update(newState: TasksState) {
        currentState = newState
    }

    override fun state() = currentState
}