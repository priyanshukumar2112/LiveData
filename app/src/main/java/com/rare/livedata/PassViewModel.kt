package com.rare.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PassViewModel : ViewModel() {
    var personName = MutableLiveData(0)

}