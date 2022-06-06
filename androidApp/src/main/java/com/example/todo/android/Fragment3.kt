package com.example.todo.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.android.databinding.Fragment2Binding
import com.example.todo.android.databinding.Fragment3Binding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_3.*


class Fragment3 : Fragment() {

    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var userList:ArrayList<UserData>
    private lateinit var userAdapter:UserAdapter
    private lateinit var binding: Fragment3Binding
    private val viewModel by viewModels<SharedViewModel>(ownerProducer = {requireActivity()})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContentView(R.layout.fragment_3)
        userList = ArrayList()
        addsBtn = addingBtn
        recv = mRecycler

        userAdapter = UserAdapter(this.requireContext(),userList)

        recv.layoutManager = LinearLayoutManager(this.requireContext())
        recv.adapter = userAdapter

        addsBtn.setOnClickListener { addInfo() }
    }

    private fun setContentView(fragment3: Int) {

    }


    private fun addInfo() {
        val inflter = LayoutInflater.from(this.requireContext())
        val v = inflter.inflate(R.layout.add_item,null)

        val userName = v.findViewById<EditText>(R.id.userName)

        val addDialog = AlertDialog.Builder(this.requireContext())

        addDialog.setView(v)
        addDialog.setPositiveButton("Ok")

        {   dialog, _->
            val names = userName.text.toString()
            userList.add(UserData("$names \n"))
            userAdapter.notifyDataSetChanged()
            dialog.dismiss()
        }

        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
        }

        addDialog.create()
        addDialog.show()

    }
}