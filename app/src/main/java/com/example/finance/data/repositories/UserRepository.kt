package com.example.finance.data.repositories

import com.example.finance.data.UserDao
import com.example.finance.data.models.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Layer of abstraction over our UserDao for access within the app. We inject this directly
 * into our ViewModels instead of the userDao.
 */
class UserRepository @Inject constructor(
    // this gets provided automatically by Hilt for interaction with our database
    private val userDao: UserDao
) {
    val getAllUsers: Flow<List<User>> = userDao.getAllUsers()
    fun getSelectedUserById(userId: Int): Flow<User>{
        return userDao.getSelectedUserById(userId)
    }
    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }
    fun searchUsers(searchQuery: String): Flow<List<User>>{
        return userDao.searchUsers(searchQuery)
    }
}