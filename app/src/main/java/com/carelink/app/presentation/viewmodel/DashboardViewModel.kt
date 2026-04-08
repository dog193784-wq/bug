package com.carelink.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.usecase.GetHealthHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val historyUseCase: GetHealthHistoryUseCase) : ViewModel() {
    private val _state = MutableStateFlow<List<HealthData>>(emptyList())
    val state: StateFlow<List<HealthData>> = _state
    fun load(parentId: String) = viewModelScope.launch { _state.value = historyUseCase(parentId) }
}
