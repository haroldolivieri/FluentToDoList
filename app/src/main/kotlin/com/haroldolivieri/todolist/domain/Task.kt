package com.haroldolivieri.todolist.domain

import java.util.*

data class Task(val name: String, val date: Date, val description: String, val completed: Boolean)