package com.example.recipefinder.ui.recipe

import android.util.Log
import com.example.recipefinder.data.RecipeModel
import retrofit2.Call
import retrofit2.Response

fun enqueueRecipeAPI(apiCall: Call<RecipeModel>, setResult: (RecipeModel) -> Unit) {
    return apiCall.enqueue(object : retrofit2.Callback<RecipeModel> {

        override fun onResponse(call: Call<RecipeModel>, response: Response<RecipeModel>) {
            if (response.isSuccessful) {
                response.body()?.let { setResult(it) }
            }
        }

        override fun onFailure(call: Call<RecipeModel>, t: Throwable) {
//            setResult()
            t.printStackTrace()
            Log.e("APITEST", t.message.toString())
        }

    })
}