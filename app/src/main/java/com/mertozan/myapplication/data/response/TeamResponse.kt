package com.mertozan.myapplication.data.response

import com.google.gson.annotations.SerializedName
import com.mertozan.myapplication.data.model.Teams

data class TeamResponse(@SerializedName("success")
                        val success: Int = 0,
                        @SerializedName("formulaTeams")
                        val formulaTeams: List<Teams>?)