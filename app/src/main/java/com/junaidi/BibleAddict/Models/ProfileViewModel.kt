package com.junaidi.BibleAddict.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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
}
