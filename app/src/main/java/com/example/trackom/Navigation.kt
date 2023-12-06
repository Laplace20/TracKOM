package com.example.trackom


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trackkom.welcomePage

@RequiresApi(Build.VERSION_CODES.O)

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcomePage") {
        composable("FirstScreen") {
            FirstScreen(navController = navController)
        }
        composable("LandingPage") {
            LandingPage(navController).menu()
        }
        composable("formKehilangan") {
            formKehilangan(navController).formKehilangan()
        }
        composable("formKetemu") {
            formKetemu(navController).formKetemu()
        }
        composable("halBarangTemuan") {
            halBarangTemuan(navController).halBarangTemuan()
        }
        composable("halBarangKehilangan") {
            halBarangKehilangan(navController).halBarangKehilangan()
        }
        composable("halCekNotifikasi") {
            cekNotifikasi(navController).halCekNotifikasi()
        }
        composable("welcomePage") {
            welcomePage(navController)
        }
        composable("test") {
            testing()
        }

        // Tambahkan tujuan lainnya di sini
    }
}




