package com.curso.android.app.practica.projectofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.projectofinal.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_InitText() = runTest {
        val text1 = viewModel.comparator.value?.text1
        val text2 = viewModel.comparator.value?.text2
        val result = viewModel.comparator.value?.resultado

        assertEquals("", text1)
        assertEquals("", text2)
        assertEquals("", result)
    }

    @Test
    fun mainViewModel_CompareTextEqual() = runTest {
        launch {
            viewModel.comparTexts("hello", "hello")
        }

        advanceUntilIdle()

        val result = viewModel.comparator.value?.resultado

        assertEquals("Los textos son iguales", result)
    }

    @Test
    fun mainViewModel_CompareTextNoEqual() = runTest {
        launch {
            viewModel.comparTexts("hello", "HELLO")
        }

        advanceUntilIdle()

        val result = viewModel.comparator.value?.resultado

        assertEquals("Los textos NO son iguales", result)
    }
}