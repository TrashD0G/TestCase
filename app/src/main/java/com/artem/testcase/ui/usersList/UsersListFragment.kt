package com.artem.testcase.ui.usersList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.artem.testcase.adapter.UsersAdapter
import com.artem.testcase.databinding.FragmentUsersListBinding
import io.reactivex.disposables.CompositeDisposable

class UsersListFragment : Fragment() {

    private var fragmentUsersListBinding: FragmentUsersListBinding? = null
    private lateinit var usersListViewModel: UsersListViewModel
    private val usersAdapter by lazy { UsersAdapter(requireContext(), usersListViewModel) }



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        //Binding
        fragmentUsersListBinding = FragmentUsersListBinding.inflate(inflater, container, false)


        //ViewModel
        usersListViewModel = ViewModelProvider(this).get(UsersListViewModel::class.java)
        usersListViewModel.getUsers()
        usersListViewModel.regresResponse.observe(viewLifecycleOwner, { response ->
            if (response.isSuccessful) {
                setupRecycvlerview()
                response.body()?.let { usersAdapter.setData(it.users) }
            } else {

                Toast.makeText(requireContext(), "Ошибка !", Toast.LENGTH_LONG).show()
            }
        })

        usersListViewModel.errorChecker.observe(viewLifecycleOwner, { error ->
            if (error) {
                setupRecycvlerview()
                Toast.makeText(requireContext(), "Ошибка подключения!", Toast.LENGTH_LONG).show()
                usersListViewModel.readAllData.observe(viewLifecycleOwner, {
                    usersAdapter.setData(it)
                })
            }
        })


        return fragmentUsersListBinding?.root
    }


    private fun setupRecycvlerview(){
        fragmentUsersListBinding?.recyclerUsers?.adapter = usersAdapter
        fragmentUsersListBinding?.recyclerUsers?.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentUsersListBinding = null
    }


}