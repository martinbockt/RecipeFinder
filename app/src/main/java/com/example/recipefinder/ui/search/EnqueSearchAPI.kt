package com.example.recipefinder.ui.search

import android.util.Log
import com.example.recipefinder.data.SearchResultModel
import com.example.recipefinder.model.RecipeModel
import retrofit2.Call
import retrofit2.Response

fun enqueueSearchAPI(apiCall: Call<SearchResultModel>, setResult: (List<RecipeModel>) -> Unit) {
    return apiCall.enqueue(object : retrofit2.Callback<SearchResultModel> {

        override fun onResponse(call: Call<SearchResultModel>, response: Response<SearchResultModel>) {
            if (response.isSuccessful) {
                response.body()?.let { setResult(it.results) }
            }
        }

        override fun onFailure(call: Call<SearchResultModel>, t: Throwable) {
            setResult(listOf())
            t.printStackTrace()
            Log.e("APITEST", t.message.toString())
        }

    })
}