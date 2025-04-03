package com.composablecode.main_app.presentation.view_model.home

import androidx.compose.runtime.snapshots.SnapshotApplyResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composablecode.main_app.domain.model.FeatureModel
import com.composablecode.main_app.domain.usecase.GetExternalFeaturesUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class HomeViewmodel(
    private val getExternalFeaturesUseCase: GetExternalFeaturesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState: SharedFlow<HomeState> = _uiState.asSharedFlow()

    private val _actions = MutableSharedFlow<HomeAction>()

    init {
        collectActions()
    }

    fun submitAction(action: HomeAction) {
        viewModelScope.launch {
            _actions.emit(action)
        }
    }

    private fun collectActions() {
        viewModelScope.launch {
            _actions.collect { action ->
                when (action) {
                    is HomeAction.LoadFeatures -> loadFeatures()
                    HomeAction.InitData -> initData()
                }
            }
        }
    }

    private  suspend fun initData(){
        loadFeatures()
    }
    private suspend fun loadFeatures() {
        _uiState.value = _uiState.value.copy(event = HomeEvent.Loading)
        try {
            val features = getExternalFeaturesUseCase.get()
            _uiState.value = _uiState.value.copy(event = HomeEvent.Success, features = features)
        } catch (ex: Exception) {
            _uiState.value = _uiState.value.copy(
                event = HomeEvent.Error(ex.message)
            )
        }
    }
}


data class HomeState(
    val features: List<FeatureModel> = emptyList(),
    val event: HomeEvent = HomeEvent.None,
)
sealed class  HomeEvent{
    data object Loading: HomeEvent()
    data class Error(val message: String?): HomeEvent()
    data object Success : HomeEvent()
    data object  None : HomeEvent()

}
sealed class HomeAction {
    data object InitData : HomeAction()
    data object LoadFeatures: HomeAction()
}
