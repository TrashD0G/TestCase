package com.artem.testcase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.artem.testcase.POJO.Data
import com.artem.testcase.databinding.UsersItemBinding
import com.artem.testcase.repository.Users
import com.artem.testcase.ui.usersList.UsersListFragmentDirections
import com.artem.testcase.ui.usersList.UsersListViewModel
import com.bumptech.glide.Glide


class UsersAdapter(private val context: Context, private val mViewModel:UsersListViewModel): RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    private var usersList = emptyList<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val itemBinding = UsersItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding,context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userData: Data = usersList[position]
        holder.bind(userData)

        val users = Users(0, userData.email, userData.firstName, userData.lastName, userData.avatar)



        if (mViewModel.errorChecker.value == false) {
            mViewModel.addUser(users)
        }

        holder.itemView.setOnClickListener {
            val action = UsersListFragmentDirections.actionNavigationUsersListToNavigationUser(userData)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    class ViewHolder(private var itemBinding: UsersItemBinding, private val context: Context) : RecyclerView.ViewHolder(itemBinding.root){

        fun bind(userData: Data){
            itemBinding.txtFistName.text = userData.firstName
            itemBinding.txtLastName.text = userData.lastName
            Glide.with(context).load(userData.avatar).into(itemBinding.imgAvatar)
        }
    }


    fun setData(newUsersList: List<Data>?) {
        usersList = newUsersList!!
        notifyDataSetChanged()
    }






}