package com.manmohan.expensetracker.data.repository

import com.manmohan.expensetracker.data.local.ExpenseDao
import com.manmohan.expensetracker.data.local.IncomeDao
import com.manmohan.expensetracker.data.local.models.Expense
import com.manmohan.expensetracker.data.local.models.Income
import com.manmohan.expensetracker.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val incomeDao: IncomeDao,
    private val expenseDao: ExpenseDao,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
):Repository {

    override val income: Flow<List<Income>>
        get() = incomeDao.getAllIncome()
    override val expense: Flow<List<Expense>>
        get() = expenseDao.getAllExpense()

    override suspend fun insertIncome(income: Income) = withContext(dispatcher) {
        incomeDao.insertIncome(income)
    }

    override suspend fun insertExpense(expense: Expense) = withContext(dispatcher) {
        expenseDao.insertExpense(expense)
    }

    override fun getIncomeById(id: Int): Flow<Income> {
        return incomeDao.getIncomeById(id)
    }

    override fun getExpenseById(id: Int): Flow<Expense> {
        return expenseDao.getExpenseById(id)
    }

    override suspend fun updateIncome(income: Income) = withContext(dispatcher) {
        incomeDao.updateIncome(income)
    }

    override suspend fun updateExpense(expense: Expense) = withContext(dispatcher) {
        expenseDao.updateExpense(expense)
    }

    override suspend fun deleteIncome(id: Int): Int = withContext(dispatcher) {
         incomeDao.deleteIncome(id)
    }

    override suspend fun deleteExpense(id: Int): Int = withContext(dispatcher) {
         expenseDao.deleteExpense(id)
    }


}