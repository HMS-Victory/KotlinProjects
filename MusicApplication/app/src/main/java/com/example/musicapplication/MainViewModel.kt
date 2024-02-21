package com.example.musicapplication

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.musicapplication.ui.theme.Screen

//inherits from ViewModel
//meaning it has access to all methods and data in ViewModel
class MainViewModel: ViewModel() {
    private val _currentScreen: MutableState<Screen> =mutableStateOf(Screen.DrawerScreen.AddAccount)

    val currentScreen: MutableState<Screen>
        get() = _currentScreen

    fun setCurrentScreen(screen:Screen){
        _currentScreen.value = screen
    }
}