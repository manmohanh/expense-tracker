package com.manmohan.expensetracker.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.manmohan.expensetracker.data.local.models.Expense
import com.manmohan.expensetracker.data.local.models.Income
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: Expense)

    @Query("DELETE FROM expense_table")
    suspend fun deleteAllExpense()

    @Query("DELETE FROM expense_table WHERE expense_id=:id")
    suspend fun deleteExpense(id:Int):Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateExpense(expense: Expense)

    @Query("SELECT * FROM expense_table")
    fun getAllExpense():Flow<List<Expense>>

    @Query("SELECT * FROM expense_table WHERE expense_id=:id")
    fun getExpenseById(id: Int):Flow<Expense>
}


@Dao
interface IncomeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIncome(income: Income)

    @Query("DELETE FROM income_table")
    suspend fun deleteAllIncome()

    @Query("DELETE FROM income_table WHERE income_id=:id")
    suspend fun deleteIncome(id:Int):Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateIncome(income: Income)

    @Query("SELECT * FROM income_table")
    fun getAllIncome():Flow<List<Income>>

    @Query("SELECT * FROM income_table WHERE income_id=:id")
    fun getIncomeById(id: Int):Flow<Income>
}