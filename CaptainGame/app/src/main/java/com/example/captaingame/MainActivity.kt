package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    captainGame()
                }
            }
        }
    }
    @Composable
    fun captainGame(){
        val treasuresFound=remember{mutableStateOf(0)}
        // the by keyword instead of the = allows you to simply reference the variable
        //itself which will contain whatever values for example "x.y" could be referenced as simply "x"
//        val treasuresFound by remember{ mutableStateOf(0)}
        val direction=remember{mutableStateOf("North")}
        val stormOrTreasure=remember{ mutableStateOf("")}

        Column{
            Text(text="Treasures Found: ${treasuresFound.value}")
            Text(text="Current Direction: ${direction.value}")
            Text(text=stormOrTreasure.value)

            Button(onClick={
                direction.value="North"
                if(Random.nextBoolean()){
                    treasuresFound.value +=1
                    stormOrTreasure.value="Found a Treasure!"
                }else{
                    stormOrTreasure.value="Storm Ahead"
                }
            }){
                Text("Sail North")
            }
            Row{
                Button(onClick={
                    direction.value="West"
                    if(Random.nextBoolean()){
                        treasuresFound.value +=1
                    }
                }){
                    Text("Sail West")
                }
                Button(onClick={
                    direction.value="East"
                    if(Random.nextBoolean()){
                        treasuresFound.value +=1
                    }
                }){
                    Text("Sail East")
                }
            }
            Button(onClick={
                direction.value="South"
                if(Random.nextBoolean()){
                    treasuresFound.value +=1
                }
            }){
                Text("Sail South")
            }
        }

    }
}