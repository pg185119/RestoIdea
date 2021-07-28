package com.ncr.restoidea.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RestaurantViewModel : ViewModel() {
    var rests: MutableLiveData<List<String>>? = null

    fun getrests(name: String): MutableLiveData<List<String>> {

        if (rests == null) {
            rests = MutableLiveData<List<String>>()
            getRestsList()

        }
        return rests as MutableLiveData<List<String>>
    }

    private fun getRestsList() {

        val list = arrayListOf<String>()
        list.add("Menu Item #1")
        list.add("Menu Item #2")
        list.add("Menu Item #3")
        list.add("Menu Item #4")
        list.add("Menu Item #5")
        rests?.value = list
    }
}