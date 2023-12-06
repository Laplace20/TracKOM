package com.example.trackom
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController

class cekNotifikasi(val navController: NavController){
    val bg = 0xFF321D6D
    val textColor = 0xFFEFF5FE
    @Composable
    fun halCekNotifikasi(){
        var notifikasi by remember { mutableStateOf("") }
        var namaPenemu by remember { mutableStateOf("")}
        val constraints = ConstraintSet{
            //---------------------Text---------------------------------
            val textCekNotifikasi = createRefFor("textCekNotifikasi")
            val namaPenemu = createRefFor("namaPenemu")
            val notifikasi = createRefFor("notifikasi")
            //---------------------Boxes--------------------------------
            val boxNotifikasi = createRefFor("boxNotifikasi")
            val boxCekNotifikasi = createRefFor("boxCekNotifikasi")
            //--------------------Button--------------------------------
            val backButton = createRefFor("backButton")
            constrain(boxCekNotifikasi){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            constrain(textCekNotifikasi){
                top.linkTo(boxCekNotifikasi.top)
                start.linkTo(boxCekNotifikasi.start)
                bottom.linkTo(boxCekNotifikasi.bottom)
                end.linkTo(boxCekNotifikasi.end)
            }
            constrain(namaPenemu){

            }
            constrain(notifikasi){

            }
            constrain(textCekNotifikasi){

            }
            constrain(backButton){
                top.linkTo(boxCekNotifikasi.top)
                start.linkTo(boxCekNotifikasi.start)
                bottom.linkTo(boxCekNotifikasi.bottom)
            }

        }
        ConstraintLayout(constraintSet = constraints, modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
            Box(modifier = Modifier
                .layoutId("boxCekNotifikasi")
                .background(
                    color = Color(bg)
                )
                .fillMaxWidth()
                .height(120.dp)){

            }
            Text(text = "Check Notifikasi", modifier = Modifier
                .layoutId("textCekNotifikasi"), color = Color(textColor), fontWeight = FontWeight.Bold
                , fontSize = 25.sp)
            IconButton(onClick = { navController.navigate("LandingPage") },
                modifier = Modifier.layoutId("backButton")
                    .padding(start = 10.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null,
                    tint = Color(textColor)
                )
            }


        }
    }
}