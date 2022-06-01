package com.example.todo.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.android.databinding.ViewHolderTodoListItemBinding
import kotlinx.android.synthetic.main.view_holder_todo_list_item.view.*

class ResultTextAdapter(private val onRemove: (String) -> Unit) : RecyclerView.Adapter<TodoListItemViewHolder>() {

    private var data: List<String> = emptyList()

    fun setNewData(newList: List<String>) {
        data = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListItemViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderTodoListItemBinding.inflate(layoutInflater, parent, false)
        return TodoListItemViewHolder(binding, onRemove)
    }

    override fun onBindViewHolder(holder: TodoListItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class TodoListItemViewHolder(
    private val binding: ViewHolderTodoListItemBinding,
    private val onRemove: (String) -> Unit
): RecyclerView.ViewHolder(binding.root){
    fun bind(item: String){
        binding.tvResult.text = item
        binding.btnRemove.setOnClickListener { onRemove(item) }
    }
}