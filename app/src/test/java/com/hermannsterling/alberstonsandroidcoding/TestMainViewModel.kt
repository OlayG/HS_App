package com.hermannsterling.alberstonsandroidcoding

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hermannsterling.alberstonsandroidcoding.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import repo.AcronymRepo

class TestMainViewModel {

    @ExperimentalCoroutinesApi
    class MainViewModelTest {
        private lateinit var viewModel: MainViewModel
        private

        @get:Rule
        val instantTaskExecutorRule = InstantTaskExecutorRule()


//        @Mock
//        private val repo = AcronymRepo()

//        @Before
//        fun setUp() {
//            viewModel = MainViewModel(repo)
//        }


//        @Test
//        fun `submitted acronym should be same as `() {
//            val garland = "Garland"
//            viewModel.getCurrentForecast(garland)
//            val forecast = viewModel.currentForecast.getOrAwaitValueTest()
//            assertEquals(garland, forecast.city.name)
//
//        }

//        @Test
//        fun `function to return null if city is empty`() {
//            val emptyCityName = ""
//            viewModel.getCurrentForecast(emptyCityName)
//            val forecast = viewModel.currentForecast.getOrAwaitValueTest()
//            assertNull(forecast)
//        }
//
//        @Test
//        fun `function to return null if city is not found`() {
//            val notACity = "something"
//            viewModel.getCurrentForecast(notACity)
//            val forecast = viewModel.currentForecast.getOrAwaitValueTest()
//            assertNull(forecast)
//        }

    }
}