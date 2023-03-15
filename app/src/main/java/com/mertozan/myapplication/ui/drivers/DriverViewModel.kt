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

    private var _driverList = MutableLiveData<ArrayList<Drivers>>()
    val driverList: MutableLiveData<ArrayList<Drivers>>
        get() = _driverList

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
                    _driverList.value = it as ArrayList
                }
            }

            override fun onFailure(call: Call<DriverResponse>, t: Throwable) {
                Log.e("Driver", t.message.orEmpty())
            }
        })
    }
}