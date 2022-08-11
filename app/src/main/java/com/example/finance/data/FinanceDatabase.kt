package com.example.finance.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finance.data.models.User

/**
 * This defines the entire local (device) database, listing the tables, version number, and an
 * optional export schema. Room will read this annotation and create our database at compile time in
 * addition to any DAOs that we have defined. Cmd + Click on @Database in android studio to learn more.
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class FinanceDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
}