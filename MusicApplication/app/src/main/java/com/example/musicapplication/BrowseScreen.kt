package com.example.musicapplication

import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.grid.GridCells
import com.example.musicapplication.ui.theme.BrowserItem

@Composable
fun BrowseScreen(){
    val categories=listOf("Hits", "Happy", "Workout", "Running", "TGIF", "Yoga")
    LazyVerticalGrid(GridCells.Fixed(2)){
        items(categories){
            cat->
            BrowserItem(cat=cat, drawable=R.drawable.baseline_apps_24)
        }
    }
}