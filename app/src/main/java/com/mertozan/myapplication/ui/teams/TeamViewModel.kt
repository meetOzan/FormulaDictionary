package com.mertozan.myapplication.ui.teams

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mertozan.myapplication.common.utils.ApiUtils
import com.mertozan.myapplication.data.model.Teams
import com.mertozan.myapplication.data.response.TeamResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamViewModel : ViewModel() {

    private var _teamList = MutableLiveData<List<Teams>>()
    val teamList : MutableLiveData<List<Teams>>
        get() = _teamList

    private val teamService = ApiUtils.getFormulaDaoInterface()

    init {
        getTeams()
    }

    private fun getTeams(){
        teamService.getTeams().enqueue(object : Callback<TeamResponse>{

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                response.body()?.formulaTeams.let {
                    _teamList.value = it
                }
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Log.e("Team",t.message.orEmpty())
            }
        })




    }


}