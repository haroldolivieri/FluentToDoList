package com.haroldolivieri.todolist.features.tasks

import io.fluent.Store
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.channels.produce

class TasksStore(initialState: TasksState) : Store<TasksState> {

    private var currentState = initialState
    private var shouldProduce = true

    override fun update(newState: TasksState) {
        currentState = newState
        shouldProduce = true
    }

    override fun state() = currentState

    fun produceStates() = produce(CommonPool) {
        while (true) {
            if (shouldProduce) {
                send(currentState)
                shouldProduce = false
            }
        }
    }
}
