package com.example.littlelemonlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

// Step One: Define a LoginScreen composable
@Composable
fun LoginScreen(){
    // Step Two: Define a vertical layout
    // Step Three: Center the content vertically and horizontally
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Step Four: Add an image composable
        Image(painter = painterResource(id = R.drawable.littlelemonlogo), contentDescription = "Logo Image")
        // Step Five: Add a text field (value and onValueChange can be blank)
        // Step Five (cont.): Use a Text composable for the label and set the value to "Username"
        TextField(value = "", onValueChange = {}, label = { Text(text = "Username")})
        // Step Seven: Add a text field for the password
        TextField(value = "", onValueChange = {}, label = { Text(text = "Password")})
        // Step Eight: Add a button (for logging in)
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF495E57))) {
            Text(text = "Login", color = Color(0xFFEDEFEE))
        }
    }
}

// Step Six: Define a Preview function for the LoginScreen
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}
