package com.example.trackom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

@Composable
fun halBarangTemuan() {
    val navController = rememberNavController()
    halBarangTemuan(navController).halBarangTemuan()
}

@Preview(showBackground = true)
@Composable
fun halBarangPreview() {
    halBarangTemuan()
}
class halBarangTemuan(val navController: NavController) {
    val boxColor = 0xFF321D6D
    val textColor = 0xFFEFF5FE
    val barangBoxColor = 0xFFFDFFE2


    @Composable
    fun halBarangTemuan(){
        val barangTemu = remember { mutableStateListOf<modelBarangHilang>() }

        LaunchedEffect(Unit) {
            val database = Firebase.database
            val myRef = database.getReference("barangKetemu")

            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    barangTemu.clear()
                    dataSnapshot.children.mapNotNullTo(barangTemu) { it.getValue(modelBarangHilang::class.java) }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle error here
                }
            })
        }

        val constraints = ConstraintSet{
            val simpanBox = createRefFor("simpanBox")
            val buttonSimpan = createRefFor("buttonSimpan")
            val barangTemuanBox = createRefFor("barangTemuanBox")
            val buttonBack = createRefFor("buttonBack")
            val searchBar = createRefFor("searchBar")
            val textBarangTemuan = createRefFor("textBarangTemuan")
            val lazyBox = createRefFor("lazyBox")
            val boxBarang = createRefFor("boxBarang")
            val textNamaBarang = createRefFor("textNamaBarang")
            val tanggal = createRefFor("tanggal")
            val lokasiBarang = createRefFor("lokasiBarang")
            constrain(barangTemuanBox){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            constrain(buttonBack){
                top.linkTo(barangTemuanBox.top)
                start.linkTo(barangTemuanBox.start)
                bottom.linkTo(barangTemuanBox.bottom)
            }
            constrain(searchBar){
                top.linkTo(barangTemuanBox.top)
                end.linkTo(barangTemuanBox.end)
                bottom.linkTo(barangTemuanBox.bottom)
            }
            constrain(textBarangTemuan){
                top.linkTo(barangTemuanBox.top)
                start.linkTo(barangTemuanBox.start)
                end.linkTo(barangTemuanBox.end)
                bottom.linkTo(barangTemuanBox.bottom)
            }
            constrain(lazyBox){
                top.linkTo(barangTemuanBox.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(simpanBox.top)
            }
            constrain(boxBarang){
                top.linkTo(lazyBox.top)
                start.linkTo(lazyBox.start)
                end.linkTo(lazyBox.end)
            }
            constrain(textNamaBarang){
                top.linkTo(boxBarang.top)
                start.linkTo(boxBarang.start)
                bottom.linkTo(lokasiBarang.top)
            }
            constrain(lokasiBarang){
                top.linkTo(textNamaBarang.bottom)
                start.linkTo(boxBarang.start)
                bottom.linkTo(tanggal.top)
            }
            constrain(tanggal){
                top.linkTo(lokasiBarang.bottom)
                start.linkTo(boxBarang.start)
                bottom.linkTo(boxBarang.bottom)
            }
            constrain(simpanBox){
                top.linkTo(lazyBox.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
            constrain(buttonSimpan){
                top.linkTo(simpanBox.top)
                start.linkTo(simpanBox.start)
                end.linkTo(simpanBox.end)
                bottom.linkTo(simpanBox.bottom)
            }
        }
        ConstraintLayout(constraintSet = constraints, modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
            Box(modifier = Modifier
                .layoutId("barangTemuanBox")
                .background(
                    color = Color(boxColor)
                )
                .fillMaxWidth()
                .height(120.dp)){
            }
            Box(modifier = Modifier
                .layoutId("lazyBox")
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(start= 8.dp, end=8.dp)
                .fillMaxWidth()
                .height(650.dp)){
                LazyColumn(modifier = Modifier.size(1000.dp, 1000.dp)) {
                    items(barangTemu) { barangHilang ->
                        Box(
                            modifier = Modifier
                                .layoutId("boxBarang")
                                .fillMaxWidth()
                                .height(90.dp)
                                .padding(top = 8.dp)
                                .background(color = Color.LightGray)
                        ) {
                            Text(
                                text = "Nama Barang: ${barangHilang.detailBarang}",
                                modifier = Modifier
                                    .layoutId("textNamaBarang")
                                    .padding(start = 7.dp, top = 5.dp)
                            )
                            Text(
                                text = "Lokasi Barang: ${barangHilang.lokasi}",
                                modifier = Modifier
                                    .layoutId("lokasiBarang")
                                    .padding(start = 7.dp, top = 25.dp)
                            )
                            Text(
                                text = "Kontak: ${barangHilang.kontak}",
                                modifier = Modifier
                                    .layoutId("tanggal")
                                    .padding(start = 7.dp, top = 45.dp)
                            )
                        }
                    }
                }
            }
            Text(text = "Barang Temuan", modifier = Modifier
                .layoutId("textBarangTemuan"), color = Color(textColor), fontWeight = FontWeight.Bold
                , fontSize = 30.sp)
            IconButton(onClick = { navController.navigate("LandingPage") },
                modifier = Modifier
                    .layoutId("buttonBack")
                    .padding(start = 10.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null,
                    tint = Color(textColor)
                )
            }
            IconButton(onClick = { navController.navigate("LandingPage") },
                modifier = Modifier
                    .layoutId("searchBar")
                    .padding(end = 10.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = null,
                    tint = Color(textColor)
                )
            }
            BottomAppBar(modifier = Modifier
                .layoutId("simpanBox")
                .background(
                    color = Color.White
                )
                .fillMaxWidth()
                .height(80.dp)){

            }
            Button(onClick = {navController.navigate("formKetemu")}, modifier = Modifier
                .layoutId("buttonSimpan")) {
                Text("Buat Laporan")
            }


        }
    }
}