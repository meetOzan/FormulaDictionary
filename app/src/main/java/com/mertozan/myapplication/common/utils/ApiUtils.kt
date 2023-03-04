package com.mertozan.myapplication.common.utils

import com.mertozan.myapplication.data.retrofit.FormulaService
import com.mertozan.myapplication.data.retrofit.RetrofitClient
import com.mertozan.myapplication.common.Constants.BASE_URL

object ApiUtils {
    fun getFormulaDaoInterface(): FormulaService =
        RetrofitClient.getClient(BASE_URL).create(FormulaService::class.java)
}