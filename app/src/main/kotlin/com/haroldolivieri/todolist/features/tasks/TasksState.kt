package com.haroldolivieri.todolist.features.tasks

import io.fluent.State
import io.fluent.StateType

data class TasksState(val type: StateType = StateType.Loading) : State {
    override fun type() = type
    fun setType(newType: StateType) = copy(type = newType)
}