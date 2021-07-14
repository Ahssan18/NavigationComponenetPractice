package com.example.navigationcomponenetpractice.Utils

import androidx.lifecycle.MutableLiveData

class Data {
    companion object{
        var amount=MutableLiveData<Long>(100L)
    }
}