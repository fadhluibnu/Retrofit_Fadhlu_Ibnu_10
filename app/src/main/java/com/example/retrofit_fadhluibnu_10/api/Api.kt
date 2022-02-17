package com.example.retrofit_fadhluibnu_10.api

import com.example.retrofit_fadhluibnu_10.model.IndonesiaResponse
import com.example.retrofit_fadhluibnu_10.model.ProvinsiResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("casenumber.json")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("casenumberprovince.json")
    fun getProvinsi(): Call<ArrayList<ProvinsiResponse>>


}