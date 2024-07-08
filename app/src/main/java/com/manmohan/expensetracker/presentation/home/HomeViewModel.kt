package com.manmohan.expensetracker.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manmohan.expensetracker.data.local.models.Expense
import com.manmohan.expensetracker.data.local.models.Income
import com.manmohan.expensetracker.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val income = repository.income
    val expense = repository.expense

    var homeUiState by mutableStateOf(HomeUiState())
        private set

    init {
        viewModelScope.launch {
            combine(
                income,
                expense
            ){ incomeList: List<Income>, expenseList: List<Expense> ->
                homeUiState.copy(
                    income = incomeList,
                    expense = expenseList,
                    totalExpense = expenseList.sumOf { it.expenseAmount }.toFloat(),
                    totalIncome = incomeList.sumOf { it.incomeAmount }.toFloat()
                )
            }.collectLatest {
                homeUiState = it
            }
        }
    }

    fun insertIncome() = viewModelScope.launch {

    }

    fun insertExpense() = viewModelScope.launch {

    }

}

data class HomeUiState(
    val income: List<Income> = emptyList(),
    val expense: List<Expense> = emptyList(),
    val totalExpense: Float = 0f,
    val totalIncome: Float = 0f
)