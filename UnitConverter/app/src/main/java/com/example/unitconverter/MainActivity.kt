package com.example.unitconverter

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Space
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import java.security.KeyStore.TrustedCertificateEntry
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

@Composable
fun UnitConverter(){

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meter") }
    var outputUnit by remember { mutableStateOf("Feet") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val iConversionFactor = remember { mutableStateOf(1.0) }
    val oConversionFactor = remember { mutableStateOf(3.28) }

    fun convertUnit(){
        // ?: - elvis operator => if null => 0.0
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val outputValueDouble = (inputValueDouble * iConversionFactor.value * oConversionFactor.value * 10000.0).roundToInt()/10000.0
        outputValue = outputValueDouble.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Here all the UI elements will be stacked below each other
        Text("Unit Converter",
            style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
            convertUnit()
        },
        label = {Text("Enter value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            // Here all the UI elements will be stacked aside each other
            Box{
                Button(onClick = { iExpanded = true }) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Millimeters") },
                        onClick = { iExpanded = false
                            inputUnit = "Millimeters"
                            iConversionFactor.value = 0.001
                            convertUnit() })
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = { iExpanded = false
                            inputUnit = "Centimeters"
                            iConversionFactor.value = 0.01
                            convertUnit() })
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = { iExpanded = false
                            inputUnit = "Meters"
                            iConversionFactor.value = 1.0
                            convertUnit() })
                    DropdownMenuItem(
                        text = { Text(text = "Kilometers") },
                        onClick = { iExpanded = false
                            inputUnit = "Kilometers"
                            iConversionFactor.value = 1000.0
                            convertUnit()})
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { oExpanded = true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")

                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Inches") },
                        onClick = {
                            oExpanded=false
                            outputUnit = "Inches"
                            oConversionFactor.value = 39.37
                            convertUnit() })
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = { oExpanded=false
                            outputUnit = "Feet"
                            oConversionFactor.value = 3.28
                            convertUnit() })
                    DropdownMenuItem(
                        text = { Text(text = "Yards") },
                        onClick = { oExpanded=false
                            outputUnit = "Yards"
                            oConversionFactor.value = 1.09
                            convertUnit() })
                    DropdownMenuItem(
                        text = { Text(text = "Miles") },
                        onClick = { oExpanded=false
                            outputUnit = "Miles"
                            oConversionFactor.value =  0.00062
                            convertUnit() })
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}