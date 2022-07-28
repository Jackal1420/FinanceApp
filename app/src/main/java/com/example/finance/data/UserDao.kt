package com.example.finance.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.finance.data.models.User
import kotlinx.coroutines.flow.Flow

/**
 * This is the data access object for our local user's data. Data Access Objects (DAOs) provide the
 * functions that our app uses to interact with a database table. ROOM will read our annotation and
 * create these functions for use at compile time.
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM user_table WHERE id=:userId")
    fun getSelectedUserById(userId: Int): Flow<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM user_table WHERE firstName LIKE :searchQuery OR lastName LIKE :searchQuery")
    fun searchUsers(searchQuery: String): Flow<List<User>>
}