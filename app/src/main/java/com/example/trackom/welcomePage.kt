package com.example.trackkom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.trackom.R

// LAYAR REGISTER KALAU TIDAK PUNYA AKUN

@Composable
fun welcomePage() {
    val navController = rememberNavController()
    welcomePage(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun welcomePage(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(modifier = Modifier
        .background(color = Color.White)
        .fillMaxSize()) {
        Box(
            modifier = Modifier
                .padding(end = 1.dp, start = 1.dp)
                .background(
                    color = Color(0xFF321D6D),
                    shape = RoundedCornerShape(0.dp, 0.dp, 30.dp, 30.dp)
                )
                .fillMaxWidth()


        ) {
            Column(
                modifier = Modifier
                    .padding(bottom = 25.dp)
                    .align(Alignment.Center)

            ) {
                Text(

                    modifier = Modifier
                        .padding(top = 200.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "Welcome to",
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.trackom),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(bottom = 1.dp)
                        .size(300.dp, 100.dp)
                        .aspectRatio(14f / 4f)
                        .background(color = Color.White, shape = RoundedCornerShape(40.dp),)
                        .align(Alignment.CenterHorizontally)
                )

            }

        }

        Text(
            modifier = Modifier
                .padding(bottom = 28.dp)
                .align(Alignment.Center),
            text = "Aplikasi yang memudahkan untuk",
            style = TextStyle(fontSize = 18.sp),
            color = Color.Black
        )
        Text(
            modifier = Modifier
                .padding(top = 45.dp, bottom = 16.dp)
                .align(Alignment.Center),
            text = "melakukan laporan barang hilang dan",
            style = TextStyle(fontSize = 18.sp),
            color = Color.Black
        )
        Text(
            modifier = Modifier
                .padding(top = 90.dp, bottom = 8.dp)
                .align(Alignment.Center),
            text = "pengembalian barang hilang dalam satu klik",
            style = TextStyle(fontSize = 18.sp),
            color = Color.Black
        )

        ElevatedButton(
            modifier = Modifier
                .width(75.dp)
                .height(75.dp)
                .padding()
                .align(Alignment.BottomEnd),
            onClick = {
                navController.navigate("firstScreen")
            }
        ) {
            Image(painter = painterResource(id = R.drawable.nextbutton), contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 1.dp)
                    .size(300.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(40.dp),)
            )
        }
    }
}

@Preview
@Composable
fun SecondScreenPreviewPreview() {
    welcomePage()
}