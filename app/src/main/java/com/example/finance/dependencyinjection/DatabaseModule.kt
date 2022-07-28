package com.example.finance.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.example.finance.data.FinanceDatabase
import com.example.finance.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Construct and provide instances of objects we want to use everywhere
 * in the application (in this case, our database and DAO).
 */

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFinanceDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        FinanceDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideUserDao(database: FinanceDatabase) = database.UserDao()
}