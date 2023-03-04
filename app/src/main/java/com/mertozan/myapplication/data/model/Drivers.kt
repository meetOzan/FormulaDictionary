package com.mertozan.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class Drivers(@SerializedName("smallUrl")
                   val smallUrl: String = "",
                   @SerializedName("number")
                   val number: String = "",
                   @SerializedName("winNum")
                   val winNum: String = "",
                   @SerializedName("nation")
                   val nation: String = "",
                   @SerializedName("championNum")
                   val championNum: String = "",
                   @SerializedName("name")
                   val name: String = "",
                   @SerializedName("poleNum")
                   val poleNum: String = "",
                   @SerializedName("team")
                   val team: String = "",
                   @SerializedName("bigUrl")
                   val bigUrl: String = "",
                   @SerializedName("age")
                   val age: String = "",
                   @SerializedName("seasonNum")
                   val seasonNum: String = "")