package com.example.hospitalaid.ui.screens.patientScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LabScreen(modifier : Modifier = Modifier){
    val dates = listOf(1,2,3,4,5,6)
    LazyColumn{
        items(dates){date->
            dateCard()
        }
    }
}

@Composable
fun dateCard(modifier :Modifier = Modifier)
{
    Column {
        Text(text = "28-AUG-2023", textDecoration = TextDecoration.Underline)
        LabScreenCardContent()
    }
}
@Composable
fun LabScreenCardContent(modifier: Modifier  =Modifier)
{
    val reports  = listOf(1,2,4,5,6,8,8,8,8,8,8)
    /*
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        modifier = modifier.padding(8.dp).height(50.dp)
    )
    {
        items(reports){report->
            LabScreenCard()

        }
    }  */

    NonlazyGrid(columns = 4, itemCount = reports.size) {
        LabScreenCard()

    }
}
@Composable
fun LabScreenCard()
{
    Card() {
        Text(text = "CBC")
    }
}

@Composable
fun NonlazyGrid(
    columns: Int,
    itemCount: Int,
    modifier: Modifier = Modifier,
    content: @Composable() (Int) -> Unit
) {
    Column(modifier = modifier) {
        var rows = (itemCount / columns)
        if (itemCount.mod(columns) > 0) {
            rows += 1
        }

        for (rowId in 0 until rows) {
            val firstIndex = rowId * columns

            Row {
                for (columnId in 0 until columns) {
                    val index = firstIndex + columnId
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        if (index < itemCount) {
                            content(index)
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LabScreenPreview()
{
    LabScreen()
}
