package com.curso.android.app.practica.projectofinal.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.projectofinal.model.Comparator

class MainViewModel: ViewModel() {

    val comparator: LiveData<Comparator> get() = _comparator

    private var _comparator = MutableLiveData<Comparator>(Comparator("", "", ""))

    fun comparTexts(text1: String, text2: String) {
        if (text1 == text2) {
            _comparator.value = Comparator(text1, text2, result(true))
        } else {
            _comparator.value =
                Comparator(text1, text2, result(false))
        }
    }

    private fun result(result: Boolean): String {
        if (result) {
            return "Los textos son iguales"
        } else {
            return "Los textos NO son iguales"
        }
    }
}