package com.example.recipefinder.data

import android.util.Log
import retrofit2.Call
import retrofit2.Response

fun enqueueAPI(apiCall: Call<SearchResultModel>, setResult: (List<RecipeModel>) -> Unit) {
    return apiCall.enqueue(object : retrofit2.Callback<SearchResultModel> {

        override fun onResponse(call: Call<SearchResultModel>, response: Response<SearchResultModel>) {
            if (response.isSuccessful) {
                setResult(response.body()!!.results)
            }
        }

        override fun onFailure(call: Call<SearchResultModel>, t: Throwable) {
            setResult(listOf())
            t.printStackTrace()
            Log.e("APITEST", t.message.toString())
        }

    })
}