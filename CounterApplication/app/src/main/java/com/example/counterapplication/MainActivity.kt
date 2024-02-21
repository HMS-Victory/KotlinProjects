package com.example.counterapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.counterapplication.ui.theme.CounterApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterApplicationTheme {
                // needed to use the viewModelProvider, instead of just viewModel
                val viewModel = ViewModelProvider(this)[CounterViewModel::class.java]
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    theCounterApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun theCounterApp(viewModel: CounterViewModel){

    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text="Count: ${viewModel.count.value}",
            fontSize = 24.sp,
            fontWeight= FontWeight.Bold
        )
        Spacer(modifier=Modifier.height(16.dp))
        Row{
            Button(onClick={viewModel.increment()}){
                Text("Increment")
            }
            Button(onClick = {viewModel.decrement()}) {
                Text("Decrement")
            }
        }
    }
}