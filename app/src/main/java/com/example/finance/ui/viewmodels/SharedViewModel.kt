package com.example.finance.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finance.data.models.User
import com.example.finance.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel(){

    // Private value that we only modify in our view model
    private val allUsers = MutableStateFlow<List<User>>(emptyList())
    // Public value that we expose to views
    val AllUsers: StateFlow<List<User>> = allUsers

    fun getAllUsers(){
        // Launch in a coroutine since getAllUsers is a suspend function
        viewModelScope.launch {
            // Collect just means 'respond to changes'
            repository.getAllUsers.collect {
                allUsers.value = it
            }
        }
    }

    suspend fun addNewUser(user: User){
        repository.addUser(user)
    }
}