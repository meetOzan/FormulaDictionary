package com.mertozan.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class Drivers(@SerializedName("smallUrl")
                   val smallUrl: String = "",
                   @SerializedName("number")
                   val number: String = "",
                   @SerializedName("winNum")
                   val winNum: Int = 0,
                   @SerializedName("nation")
                   val nation: String = "",
                   @SerializedName("championNum")
                   val championNum: Int = 0,
                   @SerializedName("name")
                   val name: String = "",
                   @SerializedName("poleNum")
                   val poleNum: Int = 0,
                   @SerializedName("team")
                   val team: String = "",
                   @SerializedName("bigUrl")
                   val bigUrl: String = "",
                   @SerializedName("age")
                   val age: Int = 0,
                   @SerializedName("seasonNum")
                   val seasonNum: Int = 0)