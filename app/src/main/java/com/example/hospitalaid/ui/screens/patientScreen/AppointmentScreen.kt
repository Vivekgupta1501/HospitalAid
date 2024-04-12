package com.example.hospitalaid.ui.screens.patientScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hospitalaid.R

@Composable
fun AppointmentScreen()
{
    val list = listOf(
        1,2,3,4,5,6,7,8,9
    )

LazyColumn(modifier = Modifier.padding(2.dp)){
    items(items = list){list->
        AppointmentCard()
        }
    }
}

@Composable
fun AppointmentCard()
{
    Card(modifier = Modifier.padding(4.dp)) {
        Column(Modifier.fillMaxWidth()) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                         contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(124.dp)
                            .clip(shape = RoundedCornerShape(8.dp)),

                    )
                    Column(Modifier.fillMaxWidth()) {
                        Row(Modifier.fillMaxWidth()) {
                            Text(text = "Dr.Tushar Gupta", style = MaterialTheme.typography.titleLarge)
                        }
                        Text(text = "Follow Up-Cardiology")
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_edit_calendar_24),
                                contentDescription = "Appointment Date",
                                modifier = Modifier.padding(18.dp)
                            )
                            Text("Date Time",style  = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
    }
}

@Preview(showBackground = true)
@Composable
fun AppointmentCardPreview()
{
    AppointmentCard()
}


