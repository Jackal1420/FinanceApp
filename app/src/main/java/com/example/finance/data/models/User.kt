package com.example.finance.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.finance.util.Constants.USER_TABLE

/**
 * This represents a single table for our users in the SQL ROOM database.
 */
@Entity(tableName = USER_TABLE)
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val email: String,
    val totalUSD: Float,
    val password: String, // Testing Purposes Only
)