package com.example.todo.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_todo_list_item.view.*

class ResultTextAdapter(resultText: MutableList<String>) : RecyclerView.Adapter<TodoListItemViewHolder>() {

    private var data = resultText

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_todo_list_item, parent, false)
        return TodoListItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TodoListItemViewHolder, position: Int) {
        val item = data[position]
        holder.itemView.tvResult.text =item
        holder.itemView.btnRemove.setOnClickListener {
            data.remove(item)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class TodoListItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

}