package com.hermannsterling.alberstonsandroidcoding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hermannsterling.alberstonsandroidcoding.model.AcronymResponse
import repo.AcronymRepo
import com.hermannsterling.alberstonsandroidcoding.utils.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val acronymRepo: AcronymRepo
) : ViewModel() {

    private val _loading = MutableLiveData<LoadingState>()
    val loading: LiveData<LoadingState>
        get() = _loading

    private val _acronymResult = MutableLiveData<AcronymResponse>()
    val acronym: LiveData<AcronymResponse>
        get() = _acronymResult


    fun fetchAcronym(acronym: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _loading.postValue(LoadingState.LOADING)
                val response = acronymRepo.getAcronymResult(acronym)
                if (response.isSuccessful) {
                    _acronymResult.postValue(response.body()?.get(0))
                    _loading.postValue(LoadingState.LOADED)
                } else {
                    _loading.postValue(LoadingState.error(response.message()))
                }

            } catch (e: Exception) {
                _loading.postValue(LoadingState.error(e.message))
            }
        }
    }
}