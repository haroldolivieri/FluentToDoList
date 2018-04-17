package com.haroldolivieri.todolist.features.tasks

import android.os.Bundle

import com.haroldolivieri.todolist.R
import dagger.android.support.DaggerAppCompatActivity

class TasksListActivity : DaggerAppCompatActivity(), TasksView {

    override fun bind(newState: TasksState) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
