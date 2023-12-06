package com.example.trackom.sealed

import com.example.trackom.modelBarangHilang

sealed class DataState {
    class Success(val data: MutableList<modelBarangHilang>):DataState()
    class Failure(val message: String) : DataState()
    object Loading : DataState()
    object Empty : DataState()
}