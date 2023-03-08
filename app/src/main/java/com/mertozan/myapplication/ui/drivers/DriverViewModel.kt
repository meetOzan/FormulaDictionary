package com.mertozan.myapplication.ui.drivers

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mertozan.myapplication.common.utils.ApiUtils
import com.mertozan.myapplication.data.model.Drivers
import com.mertozan.myapplication.data.response.DriverResponse
import com.mertozan.myapplication.data.retrofit.FormulaService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DriverViewModel : ViewModel() {

    private var _driverList = MutableLiveData<List<Drivers>>()
    val driverList: MutableLiveData<List<Drivers>>
        get() = _driverList

    private val _searchedDrivers = MutableLiveData<List<Drivers>>()
    val searchedDrivers : MutableLiveData<List<Drivers>>
        get() = _searchedDrivers

    private val driverService: FormulaService = ApiUtils.getFormulaDaoInterface()

    init {
        getDrivers()
    }

    private fun getDrivers() {
        driverService.getDrivers().enqueue(object : Callback<DriverResponse> {

            override fun onResponse(
                call: Call<DriverResponse>,
                response: Response<DriverResponse>
            ) {
                response.body()?.formulaDrivers?.let {
                    _driverList.value = it
                }
            }

            override fun onFailure(call: Call<DriverResponse>, t: Throwable) {
                Log.e("Driver", t.message.orEmpty())
            }
        })
    }

    fun searchDriver(name: String,list: MutableLiveData<List<Drivers>>){
        driverService.searchDriver(name).enqueue(object : Callback<DriverResponse>{
            override fun onResponse(
                call: Call<DriverResponse>,
                response: Response<DriverResponse>
            ) {
                response.body()?.formulaDrivers.let {
                    list.value = it
                }
            }

            override fun onFailure(call: Call<DriverResponse>, t: Throwable) {
                Log.e("Search",t.message.orEmpty())
            }
        })
    }
}