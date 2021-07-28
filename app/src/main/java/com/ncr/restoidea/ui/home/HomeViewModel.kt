package com.ncr.restoidea.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
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
        list.add("Restaurant #1")
        list.add("Restaurant #2")
        list.add("Restaurant #3")
        list.add("Restaurant #4")
        list.add("Restaurant #5")
        rests?.value = list
    }
}