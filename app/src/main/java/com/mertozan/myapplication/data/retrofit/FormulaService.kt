package com.mertozan.myapplication.data.retrofit

import com.mertozan.myapplication.data.response.DriverResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface FormulaService {

    @GET("formula/all_drivers.php")
    fun getDrivers() : Response<Call<DriverResponse>>
}