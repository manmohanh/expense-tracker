package com.manmohan.expensetracker.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.manmohan.expensetracker.ui.theme.ExpenseTrackerTheme

@Composable
fun HomeScreen(
    state: HomeUiState,
    modifier: Modifier
) {
    
    
    
}

@Preview(showSystemUi = true)
@Composable
fun HomePreview() {
    ExpenseTrackerTheme {
        HomeScreen(
            state = HomeUiState(),
            modifier = Modifier
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomePreviewDark() {
    ExpenseTrackerTheme(darkTheme = true) {
        HomeScreen(
            state = HomeUiState(),
            modifier = Modifier
        )
    }
}