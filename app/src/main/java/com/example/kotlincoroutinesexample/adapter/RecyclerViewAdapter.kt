package com.example.kotlincoroutinesexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutinesexample.R
import com.example.kotlincoroutinesexample.model.TodoModel
import kotlinx.android.synthetic.main.row_item.view.*

class RecyclerViewAdapter(private val todoList : ArrayList<TodoModel>, private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener {
        fun onItemClick(todoModel: TodoModel)
    }

    class RowHolder(view : View) : RecyclerView.ViewHolder(view) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.itemView.todo_name.text = todoList[position].title
        holder.itemView.todo_num.text = position.toString()

        holder.itemView.setOnClickListener {
            listener.onItemClick(todoModel = todoList[position])
        }
    }


    override fun getItemCount(): Int {
        return todoList.count()
    }
}