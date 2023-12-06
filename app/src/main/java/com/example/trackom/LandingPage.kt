package com.example.trackom


import android.os.Bundle
import android.util.Half
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.compose.rememberNavController
import com.example.trackom.ui.theme.TracKOMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingPagePreview() {
    val navController = rememberNavController()
    LandingPage(navController).menu()
}

@Preview
@Composable
fun LandingPagePreviewPreview() {
    LandingPagePreview()
}

class LandingPage(val NavController: NavController) {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun menu(){

        //-------------------Animasi------------------------------------------
        var clicked by remember { mutableStateOf(false) }
        val animatedHeight by animateDpAsState(
            targetValue = if (clicked) 120.dp else 80.dp,
            animationSpec = tween(300))
        //------------------Colors--------------------------------------------
        val helloBoxBg = 0xFF321D6D
        val bg = 0xFF321D6D
        val textColor2 = 0xFFEFF5FE
        val textColor = 0xFF191D30
        val buttonColor = 0xFFEFF5FE

        val constraints = ConstraintSet{
            //-----------------Dekorasi----------------------------------------
            val helloBox = createRefFor("helloBox")
            val bubble1 = createRefFor("bubble1")
            val bubble2 = createRefFor("bubble2")
            //-----------------Container--------------------------------------
            val containerButton = createRefFor("containerButton")
            //-----------------Button------------------------------------------
            val buttonBarangHilang = createRefFor("buttonBarangHilang")
            val buttonBarangTemuan = createRefFor("buttonBarangTemuan")
            val buttonCekNotifikasi = createRefFor("buttonCekNotifikasi")
            //-----------------Text--------------------------------------------
            val textHello = createRefFor("textHello")
            val textBasaBasi = createRefFor("textBasaBasi")
            val textBarangTemuan = createRefFor("textBarangTemuan")
            val textBarangHilang = createRefFor("textBarangHilang")
            val textCekNotifikasi = createRefFor("textCekNotifikasi")
            //----------------Dekorasi-----------------------------------------
            constrain(helloBox){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            //---------------Container-------------------------------------
            constrain(containerButton){
                top.linkTo(helloBox.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            //--------------Button-----------------------------------------
            constrain(buttonBarangHilang){
                top.linkTo(parent.top)
                bottom.linkTo(containerButton.bottom)
                start.linkTo(parent.start)
                end.linkTo(buttonBarangTemuan.start)
            }
            constrain(buttonBarangTemuan){
                top.linkTo(parent.top)
                bottom.linkTo(containerButton.bottom)
                start.linkTo(buttonBarangHilang.end)
                end.linkTo(parent.end)
            }
            constrain(buttonCekNotifikasi) {
                top.linkTo(helloBox.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(containerButton.bottom)
            }
            //-------------------Text--------------------------------------
            constrain(textBarangHilang){
                top.linkTo(buttonBarangHilang.top)
                bottom.linkTo(buttonBarangHilang.bottom)
                start.linkTo(buttonBarangHilang.start)
                end.linkTo((buttonBarangHilang.end))
            }
            constrain(textCekNotifikasi){
                top.linkTo(buttonCekNotifikasi.top)
                bottom.linkTo(buttonCekNotifikasi.bottom)
                start.linkTo(buttonCekNotifikasi.start)
                end.linkTo(buttonCekNotifikasi.end)
            }
            constrain(textHello){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(helloBox.bottom)
            }
            constrain(textBasaBasi){
                top.linkTo(textHello.bottom)
                bottom.linkTo(helloBox.bottom)
                start.linkTo(parent.start)
            }
            constrain(textBarangTemuan){
                top.linkTo(buttonBarangTemuan.top)
                bottom.linkTo(buttonBarangTemuan.bottom)
                start.linkTo(buttonBarangTemuan.start)
                end.linkTo((buttonBarangTemuan.end))
            }
//            constrain(bubble1){
//                top.linkTo(buttonCekNotifikasi.bottom)
//            }
        }
        ConstraintLayout(constraints, modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .layoutId("helloBox")
                .padding(bottom = 3.dp)
                .background(color = Color(bg), shape = MaterialTheme.shapes.extraSmall)){

            }

            Text(text = "Halo!", modifier = Modifier
                .layoutId("textHello")
                .padding(start = 20.dp, bottom = 10.dp),
                color = Color(textColor2), fontSize = 32.sp, fontWeight = FontWeight.Bold)

            Text(text = "Apa yang anda ingin laporkan?", modifier = Modifier
                .layoutId("textBasaBasi")
                .padding(start = 20.dp, bottom = 40.dp),
                color = Color(textColor2), fontSize = 18.sp, fontWeight = FontWeight.Light)

            Box( modifier = Modifier
                .layoutId("buttonBarangHilang")
                .size(155.dp, 126.dp)
                .padding(top = 25.dp, start = 2.dp, end =2.dp )
                .clickable{
                    clicked = !clicked
                    NavController.navigate("halBarangKehilangan")
                }
                .background(
                    color = Color(buttonColor),
                    shape = MaterialTheme.shapes.medium
                )
                .shadow(0.9.dp, shape = MaterialTheme.shapes.medium)) {

            }
            Text(text = "Barang \nHilang", modifier = Modifier
                .layoutId("textBarangHilang"), fontWeight = FontWeight.Bold, fontSize = 20.sp,color = Color(textColor))

            Box( modifier = Modifier
                .layoutId("buttonBarangTemuan")
                .size(155.dp, 126.dp)
                .padding(top = 25.dp, start = 2.dp, end =2.dp )
                .clickable{
                    clicked = !clicked
                    NavController.navigate("halBarangTemuan")
                }
                .background(
                    color = Color(buttonColor),
                    shape = MaterialTheme.shapes.medium
                )
                .shadow(0.9.dp, shape = MaterialTheme.shapes.medium)) {

            }
            Text(text = "Barang \nTemuan",modifier = Modifier
                .layoutId("textBarangTemuan"), fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(textColor))

            Box(modifier = Modifier
                .layoutId("buttonCekNotifikasi")
                .size(332.dp, 87.dp)
                .padding(top = 5.dp)
                .clickable{
                    clicked = !clicked
                    NavController.navigate("halCekNotifikasi")
                }
                .background(
                    color = Color(buttonColor),
                    shape = MaterialTheme.shapes.medium)
                .shadow(1.dp, shape = MaterialTheme.shapes.small)){

            }
            Text(text = "Cek Notifikasi", modifier = Modifier
                .layoutId("textCekNotifikasi"), fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(textColor))

        }

    }

}




