package com.example.recipefinder.ui.search

import android.util.Log
import com.example.recipefinder.data.RandomRecipeResult
import com.example.recipefinder.model.RecipeModel
import retrofit2.Call
import retrofit2.Response

fun enqueueRandomAPI(apiCall: Call<RandomRecipeResult>, setResult: (List<RecipeModel>) -> Unit) {
    return apiCall.enqueue(object : retrofit2.Callback<RandomRecipeResult> {

        override fun onResponse(call: Call<RandomRecipeResult>, response: Response<RandomRecipeResult>) {
            if (response.isSuccessful) {
                response.body()?.let { setResult(it.recipes) }
            }
        }

        override fun onFailure(call: Call<RandomRecipeResult>, t: Throwable) {
            setResult(listOf())
            t.printStackTrace()
            Log.e("APITEST", t.message.toString())
        }

    })
}