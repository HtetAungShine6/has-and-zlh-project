package com.example.todo.android.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)