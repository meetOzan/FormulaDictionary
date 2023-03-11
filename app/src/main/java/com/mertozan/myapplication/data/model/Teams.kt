package com.mertozan.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class Teams(@SerializedName("teamName")
                 val teamName: String = "",
                 @SerializedName("teamChampNum")
                 val teamChampNum: Int = 0,
                 @SerializedName("id")
                 val id: String = "",
                 @SerializedName("logoUrl")
                 val logoUrl: String = "",
                 @SerializedName("home")
                 val home: String = "")