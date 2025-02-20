package com.manmohan.expensetracker.data.repository

import com.manmohan.expensetracker.data.local.models.Expense
import com.manmohan.expensetracker.data.local.models.Income
import kotlinx.coroutines.flow.Flow

interface Repository {

    val income: Flow<List<Income>>
    val expense:Flow<List<Expense>>

    suspend fun insertIncome(income: Income)
    suspend fun insertExpense(expense: Expense)

    fun getIncomeById(id:Int):Flow<Income>
    fun getExpenseById(id: Int):Flow<Expense>

    suspend fun updateIncome(income: Income)
    suspend fun updateExpense(expense: Expense)

    suspend fun deleteIncome(id: Int):Int
    suspend fun deleteExpense(id: Int):Int
}