package com.haroldolivieri.todolist.features.tasks

import io.fluent.Store
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.channels.produce

class TasksStore(initialState: TasksState) : Store<TasksState> {
    private var currentState = initialState

    override fun update(newState: TasksState) {
        currentState = newState
    }

    override fun state() = currentState
}
