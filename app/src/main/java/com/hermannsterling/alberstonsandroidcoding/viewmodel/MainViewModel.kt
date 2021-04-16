package com.hermannsterling.alberstonsandroidcoding.viewmodel

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hermannsterling.alberstonsandroidcoding.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import repo.AcronymRepo
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val acronymRepo: AcronymRepo) : ViewModel() {

    companion object {
        private const val DEFAULT_ERROR = "No data found for"
        private const val SERVER_ERROR = "Something went wrong"
    }

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    val acronym = ObservableField("")

    fun fetchAcronym(view: View) {
        _state.value = State.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val state = try {
                acronym.get().let { query ->
                    if (query.isNullOrBlank()) State.Error("No query to search")
                    else acronymRepo.getAcronymResult(query).run {
                        val data = body()?.firstOrNull()?.longForms
                        if (isSuccessful && data != null) State.Success(data)
                        else State.Error(String.format("%s %s", DEFAULT_ERROR, query))
                    }
                }
            } catch (e: Exception) {
                State.Error(SERVER_ERROR)
            }
            _state.postValue(state)
        }
    }

}