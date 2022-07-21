package com.example.finance.data

import androidx.room.Database
import com.example.finance.data.models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class FinanceDatabase {
    abstract fun UserDao(): UserDao
}