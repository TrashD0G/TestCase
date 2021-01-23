package com.artem.testcase.ui.aboutProgram

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutProgramViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Тестовое задание для Rentateam"
    }
    val text: LiveData<String> = _text
}