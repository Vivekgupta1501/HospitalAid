package com.example.hospitalaid.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.hospitalaid.model.User
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel: ViewModel() {
    private val _uistate  = MutableStateFlow(User())
    val uistate:StateFlow<User> = _uistate.asStateFlow()

    val auth = firebaseauth.getAuth()
    val db = Firebase.firestore

    val database = FirebaseDatabase.getInstance()

    fun createUser()
    {
        val userRefrence  = database.getReference("User/"+auth.currentUser?.uid.toString())
        userRefrence.setValue(uistate).addOnCompleteListener { task->
            if(task.isSuccessful)
            {
                Log.d("USER","Real time user added")
            }
            else
            {
                Log.w("USER","Real time user creation failed-"+task.exception.toString())
            }
        }
    }

    fun signIn(email: String,password:String)
    {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { task->
                if(task.isSuccessful)
                {
                    Log.d("USER","User created successfuly")
                    val userCurrent = auth.currentUser
                    createUser()
                    db.collection("Users").document(auth.currentUser?.uid.toString())
                        .set(uistate)
                        .addOnCompleteListener { task->
                            if(task.isSuccessful)
                            {
                                Log.d("USER","User added to database")
                            }
                            else
                            {
                                Log.d("User","User not added to database-"+task.exception.toString())
                            }
                        }
                }
                else
                {
                    Log.w("USER","User creation failed")
                }
            }
    }

    fun LoginUser(email: String,password: String,navController: NavController)
    {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { task->
                if (task.isSuccessful)
                {
                    navController.navigate("home")
                    Log.d("USER","User Logged in sucessfuly")
                }
                else
                {
                    Log.w("USER","User Logged in failed-"+task.exception.toString())
                }

            }
    }
    fun signOutUser(navController: NavController)
    {
        auth.signOut()
        navController.navigate("auth")
    }
    fun userLoggedInStatus():Boolean {
        if (auth.currentUser != null)
        {
            Log.d("USER","USER LOGGED IN")
            return true
        }
        else
        {
            Log.d("USER","USER NOT LOGGED IN")
            return false
        }
    }
    fun updateUser(email: String,password: String,age:String,name: String) {
        _uistate.update {
            it.copy(
                name = name,
                email = email,
                password = password,
                age = age
            )
        }
    }
}

object firebaseauth{
    private lateinit var auth: FirebaseAuth

    init {
        auth  = Firebase.auth
    }

    fun getAuth(): FirebaseAuth
    {
        return auth
    }
}