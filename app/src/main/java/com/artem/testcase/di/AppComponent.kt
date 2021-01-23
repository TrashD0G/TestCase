package com.artem.testcase.di

import com.artem.testcase.retrofit.ApiRequest
import com.artem.testcase.ui.usersList.UsersListFragment
import com.artem.testcase.ui.usersList.UsersListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UsersListProvides::class])
interface AppComponent {
    fun injectUsersListFragment(usersListFragment: UsersListFragment)
    fun injectUsersListViewModel(usersListViewModel: UsersListViewModel)
    fun injectApiRequest(apiRequest: ApiRequest)
}