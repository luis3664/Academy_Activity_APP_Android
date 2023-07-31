package com.curso.android.app.practica.projectofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.projectofinal.view.MainViewModel
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Test
    fun mainViewModel_CompareText() = runTest {
        var text1 = viewModel.comparator.value?.text1
        var text2 = viewModel.comparator.value?.text2
        var result = viewModel.comparator.value?.resultado

        if (text1 == text2)
//        assertEquals(1,1)
    }
}