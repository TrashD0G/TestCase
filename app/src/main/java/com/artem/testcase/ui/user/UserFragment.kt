package com.artem.testcase.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.artem.testcase.R
import com.artem.testcase.databinding.FragmentUserBinding
import com.artem.testcase.databinding.FragmentUsersListBinding
import com.artem.testcase.ui.usersList.UsersListFragment
import com.bumptech.glide.Glide

class UserFragment : Fragment() {

    private var fragmentUserBinding: FragmentUserBinding? = null
    private lateinit var userViewModel: UserViewModel

    private val args by navArgs<UserFragmentArgs>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        //Binding
        fragmentUserBinding = FragmentUserBinding.inflate(inflater, container, false)
        fragmentUserBinding?.txtUserFistName?.text = args.User.firstName
        fragmentUserBinding?.txtUserLastName?.text = args.User.lastName
        Glide.with(requireContext()).load(args.User.avatar).into(fragmentUserBinding!!.imgUserAvatar)

        //ViewModel
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        


        return fragmentUserBinding?.root
    }


    override fun onDestroy() {
        super.onDestroy()
        fragmentUserBinding = null
    }
}