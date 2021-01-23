package com.artem.testcase.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UserViewModel() : ViewModel() {

    private val _firsName: MutableLiveData<String> = MutableLiveData()
    var firsName = _firsName
    private val  _lastName: MutableLiveData<String> = MutableLiveData()
    var lastName = _lastName
    private val _email: MutableLiveData<String> = MutableLiveData()
    var email = _email



    fun bind(args:UserFragmentArgs){
        _firsName.value = args.User.firstName
        _lastName.value = args.User.lastName
        _email.value = args.User.email
    }

}