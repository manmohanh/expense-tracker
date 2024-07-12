package com.manmohan.expensetracker.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manmohan.expensetracker.presentation.components.AccountCard
import com.manmohan.expensetracker.presentation.components.IncomeCard
import com.manmohan.expensetracker.ui.theme.ExpenseTrackerTheme
import com.manmohan.expensetracker.util.formatAmount

@Composable
fun HomeScreen(
    state: HomeUiState,
    modifier: Modifier,
    onIncomeClick: (Int) -> Unit,
    onClickSeeAllIncome: () -> Unit
) {

    LazyColumn(modifier = modifier) {
        item {
            Column {

                val balance = state.totalIncome - state.totalExpense
                Spacer(modifier = Modifier.height(12.dp))
                Row {
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Your total balance is:")
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "$",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    AccountCard(
                        cardTitle = "TOTAL INCOME",
                        amount = "+$",
                        cardIcon = Icons.Default.ArrowUpward,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 4.dp, top = 8.dp, bottom = 8.dp, end = 4.dp)
                    )

                    AccountCard(
                        cardTitle = "TOTAL EXPENSE",
                        amount = "-$",
                        cardIcon = Icons.Default.ArrowDownward,
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 8.dp, bottom = 8.dp, end = 4.dp)
                    )


                }
            }
        }

        item {

            IncomeCard(
                account = state,
                onIncomeClick = onIncomeClick,
                onClickSeeAll = onClickSeeAllIncome
            )

        }


    }


}

@Preview(showSystemUi = true)
@Composable
fun HomePreview() {
    ExpenseTrackerTheme {
        HomeScreen(
            state = HomeUiState(),
            modifier = Modifier,
            onIncomeClick = {},
            onClickSeeAllIncome = {}
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomePreviewDark() {
    ExpenseTrackerTheme(darkTheme = true) {
        HomeScreen(
            state = HomeUiState(),
            modifier = Modifier,
            onIncomeClick = {},
            onClickSeeAllIncome = {}
        )
    }
}