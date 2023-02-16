package com.example.recipefinder


import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.core.view.WindowCompat
import com.example.recipefinder.data.*
import com.example.recipefinder.ui.RecipefinderApp
import retrofit2.Call
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private val themeViewModel: ThemeViewModel by viewModels()
    private lateinit var dataStoreUtil: DataStoreUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataStoreUtil = DataStoreUtil(applicationContext)

        val systemTheme = when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> { true }
            Configuration.UI_MODE_NIGHT_NO -> { false }
            else -> { false }
        }
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val theme = dataStoreUtil.getTheme(systemTheme).collectAsState(initial = systemTheme)

            RecipefinderApp(theme, dataStoreUtil, themeViewModel )
        }
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getRecipeById(643859)
        val call2 = serviceGenerator.searchRecipe(query = "Burger", number = "2")
        val call3 = serviceGenerator.getRandomRecipe()

        call3.enqueue(object : retrofit2.Callback<RandomRecipeResult>{

            override fun onResponse(call: Call<RandomRecipeResult>, response: Response<RandomRecipeResult> ) {
                Log.e("APITEST response", "${response}")
                if (response.isSuccessful) {
                    Log.e("APITEST body", response.body().toString())
                }
            }

            override fun onFailure(call: Call<RandomRecipeResult>, t: Throwable) {
                t.printStackTrace()
                Log.e("APITEST", t.message.toString())
            }

        })
    }
}