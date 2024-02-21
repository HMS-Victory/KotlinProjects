package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConverter(){
    val inputValue = remember{mutableStateOf("")}
    val outputValue = remember{ mutableStateOf("")}
    val inputUnit = remember{ mutableStateOf("Meters")}
    val outputUnit = remember{ mutableStateOf("Meters")}
    val inputExpanded = remember{ mutableStateOf(false)}
    val outputExpanded = remember{ mutableStateOf(false)}
    val inputConversionFactor=remember{ mutableStateOf(1.00)}
    val outputConversionFactor=remember{ mutableStateOf(1.00)}

//    val customTextStyle= TextStyle(
//        fontFamily= FontFamily.Monospace,
//        fontSize=32.sp,
//        color= Color.Red
//    )

    fun convertUnits(){
        //?: elvis operator
        //basically if value is null do this
        val inputValueDouble=inputValue.value.toDoubleOrNull() ?:0.0
        val result=(inputValueDouble * inputConversionFactor.value * 100.0 / outputConversionFactor.value).roundToInt() / 100.0
        outputValue.value=result.toString()
    }

    Column(
           modifier=Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
        ) {

        //Here all the UI elements will be stacked below each other
        Text(text = "Unit Converter", style=MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue.value,
            onValueChange = {
            inputValue.value=it
            convertUnits()
            //Here goes what should happen, when the Value off our OutlinedTextField changes
        },label={Text("Enter Value")})
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            //Input Box
            Box {
                //Input Button
                Button(onClick = { inputExpanded.value=true }) {
                    Text(text=inputUnit.value)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(expanded = inputExpanded.value, onDismissRequest = { inputExpanded.value=false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            inputExpanded.value=false
                            inputUnit.value="Centimeters"
                            inputConversionFactor.value=0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            inputExpanded.value=false
                            inputUnit.value="Meters"
                            inputConversionFactor.value=1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            inputExpanded.value=false
                            inputUnit.value="Feet"
                            inputConversionFactor.value=0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Millimeters") },
                        onClick = {
                            inputExpanded.value=false
                            inputUnit.value="Millimeters"
                            inputConversionFactor.value=0.001
                            convertUnits()
                        }
                    )
                }
                Spacer(modifier=Modifier.width(16.dp))
            }
            Spacer(modifier=Modifier.width(16.dp))
            //Output Box
            Box{
                Button(onClick = { outputExpanded.value=true }) {
                    Text(text=outputUnit.value)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(expanded = outputExpanded.value, onDismissRequest = { outputExpanded.value=false }) {
                    DropdownMenuItem(
                        text = { Text(text="Centimeters") },
                        onClick = {
                            outputExpanded.value=false
                            outputUnit.value="Centimeters"
                            outputConversionFactor.value=0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text="Meters") },
                        onClick = {
                            outputExpanded.value=false
                            outputUnit.value="Meters"
                            outputConversionFactor.value=1.00
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text="Feet") },
                        onClick = {
                            outputExpanded.value=false
                            outputUnit.value="Feet"
                            outputConversionFactor.value=0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text="Millimeters") },
                        onClick = {
                            outputExpanded.value=false
                            outputUnit.value="Millimeters"
                            outputConversionFactor.value=0.001
                            convertUnits()
                        }
                    )
                }
            }
            //Here all the UI elements will be stacked next to each other


        }
        Spacer(modifier = Modifier.height(16.dp))
        //Result Text
        Text(text= "Result: ${outputValue.value} ${outputUnit.value}",
            style=MaterialTheme.typography.headlineMedium
        )
    }
}

@Preview(showBackground=true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}