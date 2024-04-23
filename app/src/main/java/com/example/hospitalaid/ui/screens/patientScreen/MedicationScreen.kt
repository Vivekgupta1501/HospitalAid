package com.example.hospitalaid.ui.screens.patientScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hospitalaid.ui.theme.md_theme_light_inversePrimary
import com.example.hospitalaid.ui.theme.md_theme_light_surfaceTint

@Composable
fun MedicationScreen()
{
    val list = listOf(
        1,2,3,4,5,6,7,8,9
    )

    LazyColumn(modifier = Modifier.padding(start = 6.dp,bottom = 2.dp,end = 6.dp, top = 2.dp)){
        items(items = list){list->
            MedicationScreenCard()
        }
    }

}

@Composable
fun MedicationScreenCard(modifier:Modifier = Modifier)
{
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(6.dp)) {
        Row(
            modifier = Modifier
                .background(color = md_theme_light_surfaceTint)
                .fillMaxWidth()
        ) {
            Text(
                text = "Medication Name",
                modifier = Modifier
                    .padding(start = 4.dp,end = 2.dp,bottom = 2.dp, top = 2.dp),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        }
        Text(
            text = "Type: Dibaties Medicine",
            fontSize = 16.sp, modifier = Modifier.padding(2.dp)
        )
        Text(
            text= "Prescribed By-Dr. Tushar Gupta",
            fontSize = 16.sp,
            modifier = Modifier.padding(2.dp)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Morning")
            Text(text = "AfterNoon")
            Text(text = "Evening")
        }


    }
}

@Preview(showBackground = true)
@Composable
fun MedicationScreenCardPreview()
{
    MedicationScreenCard()
}
@Preview
@Composable
fun MedicationScreenPreview()
{
   // MedicationScreen()
}