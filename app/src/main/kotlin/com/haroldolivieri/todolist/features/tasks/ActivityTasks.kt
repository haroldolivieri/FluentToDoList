package com.haroldolivieri.todolist.features.tasks

import android.annotation.SuppressLint
import android.os.Bundle

import com.haroldolivieri.todolist.R
import dagger.android.support.DaggerAppCompatActivity
import io.fluent.Hub
import io.fluent.StateType
import io.fluent.Store
import io.fluent.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.runBlocking
import javax.inject.Inject

interface TasksView: View<TasksState>

class TasksListActivity : DaggerAppCompatActivity(), TasksView {

    @Inject lateinit var store: Store<TasksState>
    @Inject lateinit var hub : Hub<@JvmSuppressWildcards TasksView>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hub.connect(this)
    }

    override fun bind(newState: TasksState) {
        when(newState.type) {
            StateType.Initial ->  status_text.text = "IDLE"
            StateType.Loading ->  status_text.text = "LOADING"
            StateType.Success ->  status_text.text = "SUCCESS"
            StateType.Error ->  status_text.text = "ERROR"
        }
    }
}


