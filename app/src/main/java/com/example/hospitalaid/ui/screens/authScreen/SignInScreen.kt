package com.example.hospitalaid.ui.screens.authScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hospitalaid.R
import com.example.hospitalaid.model.User
import com.example.hospitalaid.ui.theme.HospitalAidTheme
import com.example.hospitalaid.viewModel.AppViewModel

@Composable
fun SignInScreen(modifier: Modifier = Modifier,viewModel: AppViewModel,user: User,navController: NavController)
{

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo of the app",
                modifier =Modifier.size(124.dp)
            )
            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = {
                    Text(text = stringResource(id = R.string.name))
                },
                leadingIcon ={
                    Image(
                        painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = "Entre the name"
                    )
                },
                trailingIcon ={
                    if(!name.isEmpty())
                    {
                        IconButton(onClick = { name = "" }) {
                            Icon(
                                Icons.Default.Clear,
                                contentDescription = "erase the name"
                            )

                        }
                    }
                },
                singleLine = true,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, bottom = 10.dp, end = 20.dp, top = 10.dp)
            )
            OutlinedTextField(
                value = age,
                onValueChange = {age = it},
                label = {
                    Text(text = stringResource(id = R.string.age))
                },
                leadingIcon ={
                    Image(
                        painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = "Entre the name"
                    )
                },
                trailingIcon ={
                    if(!age.isEmpty())
                    {
                        IconButton(onClick = {age = "" }) {
                            Icon(
                                Icons.Default.Clear,
                                contentDescription = "erase the age"
                            )

                        }
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, bottom = 10.dp, end = 20.dp, top = 10.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it},
                label = {
                    Text(text = stringResource(id = R.string.email))
                },
                leadingIcon ={
                    Image(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = "Entre the email"
                    )
                },
                trailingIcon ={
                    if(!email.isEmpty())
                    {
                        IconButton(onClick = { email ="" }) {
                            Icon(
                                Icons.Default.Clear,
                                contentDescription = "erase the email"
                            )

                        }
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, bottom = 10.dp, end = 20.dp, top = 10.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                label = {
                    Text(text = stringResource(id = R.string.password))
                },
                leadingIcon ={
                    Image(
                        painter = painterResource(id = R.drawable.baseline_lock_24),
                        contentDescription = "Entre the email"
                    )
                },
                trailingIcon ={
                    if(!password.isEmpty())
                    {
                        IconButton(onClick = { password = "" }) {
                            Icon(
                                Icons.Default.Clear,
                                contentDescription = "erase the password"
                            )

                        }
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, bottom = 10.dp, end = 20.dp, top = 10.dp)
            )
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {confirmPassword = it},
                label = {
                    Text(text = stringResource(id = R.string.confirm_password))
                },
                leadingIcon ={
                    Image(
                        painter = painterResource(id = R.drawable.baseline_lock_24),
                        contentDescription = "Entre the password"
                    )
                },
                trailingIcon ={
                    if(!password.isEmpty())
                    {
                        IconButton(onClick = { password = "" }) {
                            Icon(
                                Icons.Default.Clear,
                                contentDescription = "erase the password"
                            )

                        }
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, bottom = 10.dp, end = 20.dp, top = 10.dp)
            )
            Button(
                onClick = {
                        viewModel.updateUser(email, password, age, name)
                          viewModel.signIn(email, password)
                    if(viewModel.userLoggedInStatus())
                    {
                        navController.navigate("home")
                    }

                },
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
            ){
                Text(text = stringResource(id = R.string.signin))
            }
            Text(text = "Already Registered")
            Text(text = "Login", fontStyle = FontStyle.Italic, modifier = Modifier.clickable {
                navController.navigate(AuthScreen.Login.route)
            }
            )
        }

    }


}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignInScreenPreview()
{
    HospitalAidTheme {
       // SignInScreen(Modifier ,AppViewModel(),User(),N)
    }

}
