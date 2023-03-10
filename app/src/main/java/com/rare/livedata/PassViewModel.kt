package com.rare.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PassViewModel() : ViewModel() {
    val list = arrayListOf("Blue Badgers", "Cheetah Colonels", "Phantom Bulls"," Crashing Amigos",
        "Bengal Bisons","Dashing Devils","Dazzling Balls","Flying Squirrels",
        "Crew X","Rule Breakers","The Squad")
    var personName = MutableLiveData<ArrayList<String>>()
    var secondList = MutableLiveData<ArrayList<String>>()
    var selectedValue = MutableLiveData<String>()
    fun addStrings(){
        System.out.println("in constructor")
        personName.value = list
        secondList.value = arrayListOf()
    }

    fun switchForward(){
        personName.value?.remove(selectedValue.value)
        secondList.value?.add(selectedValue.value.toString())
    }

    /*fun passdata(msg : String){
        personName.value= msg
    }*/
}