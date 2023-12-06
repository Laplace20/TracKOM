package com.example.trackom

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import com.google.firebase.database.FirebaseDatabase

class formKehilangan(val navController: NavController) {


    val bg = 0xFF321D6D
    val textColor = 0xFFEFF5FE
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun formKehilangan(){
        var namaBarang by remember { mutableStateOf("") }
        var kontak by remember { mutableStateOf("") }
        var jenisBarang by remember { mutableStateOf("")}
        var lokasi by remember { mutableStateOf("")}
        var tanggal by remember { mutableStateOf("")}
        var detailBarang by remember { mutableStateOf("")}
        val constraints = ConstraintSet{
            //---------------------Text------------------------------------------
            val textKehilangan = createRefFor("textKehilangan")
            //---------------------Boxes-----------------------------------------
            val headerBox = createRefFor("headerBox")
            val formBox = createRefFor("formBox")
            val nameBox = createRefFor("nameBox")
            val kontakBox = createRefFor("kontakBox")
            val jenisBarangBox = createRefFor("jenisBarangBox")
            val lokasiBox = createRefFor("lokasiBox")
            val tanggalKehilangan = createRefFor("tanggalKehilangan")
            val detailBox = createRefFor("detailBox")
            //----------------------Button---------------------------------------
            val buttonSimpan = createRefFor("buttonSimpan")
            constrain(headerBox){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(formBox.top)
            }
            constrain(textKehilangan){
                top.linkTo(headerBox.top)
                start.linkTo(headerBox.start)
                bottom.linkTo(headerBox.bottom)
            }
            constrain(formBox){
                top.linkTo(textKehilangan.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
            constrain(nameBox){
                top.linkTo(formBox.top)
                start.linkTo(formBox.start)
                end.linkTo(formBox.end)
                bottom.linkTo(kontakBox.top)
            }
            constrain(kontakBox){
                top.linkTo(nameBox.bottom)
                start.linkTo(formBox.start)
                end.linkTo(formBox.end)
                bottom.linkTo(jenisBarangBox.top)
            }
            constrain(jenisBarangBox){
                top.linkTo(kontakBox.bottom)
                start.linkTo(formBox.start)
                end.linkTo(formBox.end)
                bottom.linkTo(lokasiBox.top)
            }
            constrain(lokasiBox){
                top.linkTo(jenisBarangBox.bottom)
                start.linkTo(formBox.start)
                end.linkTo(formBox.end)
                bottom.linkTo(tanggalKehilangan.top)
            }
            constrain(tanggalKehilangan){
                top.linkTo(lokasiBox.bottom)
                start.linkTo(formBox.start)
                end.linkTo(formBox.end)
                bottom.linkTo(detailBox.top)
            }
            constrain(detailBox){
                top.linkTo(tanggalKehilangan.bottom)
                start.linkTo(formBox.start)
                end.linkTo(formBox.end)
                bottom.linkTo(buttonSimpan.bottom)
            }
            constrain(buttonSimpan){
                top.linkTo(detailBox.bottom)
                start.linkTo(formBox.start)
                end.linkTo(formBox.end)
                bottom.linkTo(formBox.bottom)
            }
        }
        ConstraintLayout(constraintSet = constraints, modifier = Modifier
            .fillMaxSize()) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .layoutId("headerBox")
                .background(
                    color = Color(bg)
                )){
            }
            Text(text = "FORM \n\nKehilangan", modifier = Modifier
                .layoutId("textKehilangan")
                .padding(start = 20.dp),
                color = Color(textColor), fontSize = 30.sp, fontWeight = FontWeight.Bold)

            Box(modifier = Modifier
                .layoutId("formBox")
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp, top = 5.dp)
                .height(600.dp)
                .shadow(elevation = 10.dp, shape = MaterialTheme.shapes.small)
                .height(100.dp)){
            }
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp)
                    .layoutId("nameBox")
                    .padding(start = 20.dp, end = 20.dp, top = 4.dp),
                value = namaBarang,
                onValueChange = { namaBarang = it },
                singleLine = true,
                label = { Text(text = "Nama", color = Color.Gray) }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp)
                    .layoutId("kontakBox")
                    .padding(start = 20.dp, end = 20.dp),
                value = kontak,
                onValueChange = { kontak = it },
                singleLine = true,
                label = { Text(text = "Kontak yang dapat dihubungi", color = Color.Gray) }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .layoutId("jenisBarangBox")
                    .padding(start = 20.dp, end = 20.dp),
                value = jenisBarang,
                onValueChange = { jenisBarang = it },
                singleLine = true,
                label = { Text(text = "Jenis Barang", color = Color.Gray) }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .layoutId("lokasiBox")
                    .padding(start = 20.dp, end = 20.dp),
                value = lokasi,
                onValueChange = { lokasi = it },
                singleLine = true,
                label = { Text(text = "Lokasi", color = Color.Gray) }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .layoutId("tanggalKehilangan")
                    .padding(start = 20.dp, end = 20.dp),
                value = tanggal,
                onValueChange = { tanggal = it },
                singleLine = true,
                label = { Text(text = "Tanggal Kehilangan", color = Color.Gray) }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .layoutId("detailBox")
                    .padding(start = 20.dp, end = 20.dp),
                value = detailBarang,
                onValueChange = { detailBarang = it },
                singleLine = true,
                label = { Text(text = "Detail Barang", color = Color.Gray) }
            )
            ElevatedButton(
                modifier = Modifier
                    .width(300.dp)
                    .height(65.dp)
                    .layoutId("buttonSimpan")
                    .padding(top = 5.dp),

                onClick = {
                    val barangHilang = modelBarangHilang(namaBarang,kontak,jenisBarang, lokasi,tanggal,detailBarang)
                    val database = FirebaseDatabase.getInstance()
                    val myRef = database.getReference("barangHilang")
                    myRef.push().setValue(barangHilang).addOnCompleteListener{task ->
                        if (task.isSuccessful) {
                            // Navigasi ke halaman LandingPage jika penyimpanan berhasil
                            navController.navigate("LandingPage")
                        } else {
                            // Menangani kegagalan penyimpanan data
                            // Di sini Anda bisa menambahkan logika atau pesan kesalahan sesuai kebutuhan
                            Log.e("TAG", "Gagal menyimpan data: ${task.exception}")
                        }

                    }
                }
            ) {
                Text(text = "Simpan", color = Color.Black,fontSize= 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}