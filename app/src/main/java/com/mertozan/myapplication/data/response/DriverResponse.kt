package com.mertozan.myapplication.data.response

import com.google.gson.annotations.SerializedName
import com.mertozan.myapplication.data.model.Drivers

data class DriverResponse(@SerializedName("success")
                          val success: Int = 0,
                          @SerializedName("formulaDrivers")
                          val formulaDrivers: List<Drivers>?)