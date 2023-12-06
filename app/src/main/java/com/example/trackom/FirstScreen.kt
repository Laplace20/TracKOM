package com.example.trackom


import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// LAYAR LOGIN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen() {
    val navController = rememberNavController()
    FirstScreen(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {

    var username by remember { mutableStateOf("") }
    Box(modifier = Modifier.background(color = Color(0xFF321D6D)).fillMaxSize()) {
        Box(
            modifier = Modifier.padding(top = 165.dp, end = 32.dp, start = 32.dp)
                .background(color = Color(0xFFEFF5FE), shape = RoundedCornerShape(30.dp))
                .width(width = 350.dp)

        ) {
            Column(
                modifier = Modifier.padding(bottom = 25.dp).align(Alignment.Center)
            ) {
                Image(

                    painter = painterResource(id = R.drawable.trackom),
                    contentDescription = null,
                    modifier = Modifier
                        .size(240.dp)
                        .align(Alignment.CenterHorizontally)
                        .aspectRatio(12f / 5f)
                )

                Text(

                    modifier = Modifier
                        .padding( bottom = 4.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "Masukkan Username anda!",
                    style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
                    color = Color(0xFF191D30)
                )

                OutlinedTextField(
                    modifier = Modifier.padding(bottom = 70.dp)
                        .width(250.dp)
                        .height(60.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(color = Color(0xFFEFF5FE), shape = RoundedCornerShape(30.dp)),
                    value = username,
                    onValueChange = { username  = it },
                    label = { Text(text = "Enter your username", color = Color.Gray) }
                )

                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .width(275.dp)
                        .height(65.dp)
                        .padding(top = 16.dp),


                    onClick = {
                        navController.navigate("LandingPage")
                    }
                ) {
                    Text(text = "Mulai Pelaporan", color = Color.White, fontWeight = FontWeight.Bold)
                }

            }
        }
    }
}

@Preview
@Composable
fun FirsScreenPreviewPreview() {
    FirstScreen()
}