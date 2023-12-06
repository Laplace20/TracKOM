package com.example.trackom.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.trackom.modelBarangHilang
import com.example.trackom.sealed.DataState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel:ViewModel() {
    val response:MutableState<DataState> = mutableStateOf(DataState.Empty)
    init {
        fetchDataFromFirebase()
    }
    private fun fetchDataFromFirebase(){
        val tempList = mutableListOf<modelBarangHilang>()
        response.value = DataState.Loading
        FirebaseDatabase.getInstance().getReference("barangHilang")
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    
                }

                override fun onCancelled(error: DatabaseError) {
                    response.value=DataState.Failure(error.message)
                }

            })

    }
}