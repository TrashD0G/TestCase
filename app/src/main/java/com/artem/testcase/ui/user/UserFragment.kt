package com.artem.testcase.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.artem.testcase.databinding.FragmentUserBinding
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

        //ViewModel
        userViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
        userViewModel.bind(args)

        userViewModel.firsName.observe(requireActivity(),{
            fragmentUserBinding?.txtUserFistName?.text = it
        })
        userViewModel.lastName.observe(requireActivity(),{
            fragmentUserBinding?.txtUserLastName?.text = it
        })
        userViewModel.email.observe(requireActivity(),{
            fragmentUserBinding?.txtUserEmail?.text = it
        })

        Glide.with(requireContext()).load(args.User.avatar).into(fragmentUserBinding!!.imgUserAvatar)

        return fragmentUserBinding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentUserBinding = null
    }
}