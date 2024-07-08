package com.manmohan.expensetracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.hilt.android.qualifiers.ApplicationContext
import com.manmohan.expensetracker.data.local.ExpenseDatabase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context):ExpenseDatabase {
        return Room.databaseBuilder(
            context,
            ExpenseDatabase::class.java,
            "transaction_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideExpenseDao(database: ExpenseDatabase) =
        database.expenseDao

    @Provides
    @Singleton
    fun provideIncomeDao(database: ExpenseDatabase) =
        database.incomeDao
}