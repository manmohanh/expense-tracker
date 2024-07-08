package com.manmohan.expensetracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.manmohan.expensetracker.data.local.models.Expense
import com.manmohan.expensetracker.data.local.models.Income

@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [Income::class, Expense::class],
    exportSchema = false,
    version = 1
)
abstract class ExpenseDatabase:RoomDatabase(){
    abstract val incomeDao:IncomeDao
    abstract val expenseDao:ExpenseDao
}