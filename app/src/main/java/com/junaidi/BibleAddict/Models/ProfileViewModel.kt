package com.junaidi.BibleAddict.Models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junaidi.BibleAddict.ApiCallsInterface
import com.junaidi.BibleAddict.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    // LiveData for currency, streak, and name
    private val _currency = MutableLiveData(5) // Initial value is 5
    val currency: LiveData<Int> get() = _currency

    private val _streak = MutableLiveData(5) // Initial value is 5
    val streak: LiveData<Int> get() = _streak

    private val _name = MutableLiveData("James") // Initial value is "James"
    val name: LiveData<String> get() = _name

    // You can add methods to update the LiveData if needed
    fun updateCurrency(newCurrency: Int) {
        _currency.value = newCurrency
    }

    fun updateStreak(newStreak: Int) {
        _streak.value = newStreak
    }

    fun updateName(newName: String) {
        _name.value = newName
    }

    /**
     * Makes an API call to fetch a post by ID using Retrofit.
     * Logs the API call response or errors encountered.
     */
    fun fetchPostById(postId: Int, onResult: (result: String) -> Unit) {
        println("API Call Inside")
        val retrofitClient = RetrofitClient.getClient()
        val api = retrofitClient.create(ApiCallsInterface::class.java)

        // Launching a coroutine in viewModelScope
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = api.getPostsByID(postId).execute()
                val responseBody = response.body()?.toString() ?: "No Response"
                println("API Response: $responseBody")
                onResult(responseBody) // Pass the result back
            } catch (e: Exception) {
                println("API Error: $e")
                onResult("Error: ${e.message}")
            }
        }
    }
}
