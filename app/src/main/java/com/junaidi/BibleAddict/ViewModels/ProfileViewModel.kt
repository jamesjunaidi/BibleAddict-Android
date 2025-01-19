package com.junaidi.BibleAddict.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junaidi.BibleAddict.Repositories.ExampleDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val exampleDataRepository = ExampleDataRepository()
    
    // LiveData for currency, streak, and name
    private val _currency = MutableLiveData(5) // Initial value is 5
    val currency: LiveData<Int> get() = _currency

    private val _streak = MutableLiveData(5) // Initial value is 5
    val streak: LiveData<Int> get() = _streak

    private val _name = MutableLiveData("James") // Initial value is "James"
    val name: LiveData<String> get() = _name

    // You can add methods to update the LiveData if needed
    fun updateCurrency(newCurrency: Int) {
        _currency.postValue(newCurrency)
    }

    fun updateStreak(newStreak: Int) {
        _streak.postValue(newStreak)
    }

    fun updateName(newName: String) {
        _name.postValue(newName)
    }

    fun fetchPost(onResult: (result:String) -> Unit) {
        val postid = 2

        viewModelScope.launch(Dispatchers.IO) {
            val result = exampleDataRepository.fetchPostById(postid)
            println("API Result: $result")
            onResult(result)
        }
    }
}
