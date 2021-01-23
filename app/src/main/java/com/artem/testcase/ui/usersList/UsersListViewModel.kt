package com.artem.testcase.ui.usersList

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.artem.testcase.POJO.Data
import com.artem.testcase.POJO.RegresPOJO
import com.artem.testcase.di.DaggerAppComponent
import com.artem.testcase.repository.Users
import com.artem.testcase.repository.UsersDatabase
import com.artem.testcase.repository.UsersRepository
import com.artem.testcase.retrofit.ApiRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class UsersListViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var apiRequest: ApiRequest

    val readAllData: LiveData<List<Data>>
    private val repository: UsersRepository

    private val _regresResponse: MutableLiveData<Response<RegresPOJO>> = MutableLiveData()
    var regresResponse = _regresResponse

    private val  _errorChecker:MutableLiveData<Boolean> = MutableLiveData()
    var errorChecker = _errorChecker



    init {
        DaggerAppComponent.create().injectUsersListViewModel(this)

        val usersDao = UsersDatabase.getInstance(application).usersDao()
        repository = UsersRepository(usersDao)
        readAllData = repository.readAllData
    }


    fun addUser(users: Users){
        viewModelScope.launch(Dispatchers.IO) { repository.addUser(users) }
    }

    fun deletAllUsers(){
        viewModelScope.launch(Dispatchers.IO) { repository.deleteAllUsers() }
    }


    fun getUsers(){

        viewModelScope.launch {

                try {
                    val response = apiRequest.getReguest()
                    _regresResponse.value = response
                    _errorChecker.postValue(false)

                    deletAllUsers()

                }catch (e:Exception){

                    _errorChecker.postValue(true)

                }

        }
    }

}