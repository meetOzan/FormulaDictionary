package com.mertozan.myapplication.data.retrofit

import com.mertozan.myapplication.data.response.DriverResponse
import com.mertozan.myapplication.data.response.TeamResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FormulaService {

    @GET("formula/all_drivers.php")
    fun getDrivers(): Call<DriverResponse>

    @GET("formula/all_teams.php")
    fun getTeams(): Call<TeamResponse>

    @POST("formula/driver_search.php")
    @FormUrlEncoded
    fun searchDriver(@Field("name") name:String): Call<DriverResponse>

}