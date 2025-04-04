package com.composablecode.main_app.app.activity.flutter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composablecode.main_app.domain.model.FeatureModel
import com.composablecode.main_app.domain.usecase.PushExternalFeatureUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

sealed class MainFlutterAction {
    data class PushFeature(val featureModel: FeatureModel) : MainFlutterAction()
}

class MainFlutterViewModel(
    private val pushFeatureUseCase: PushExternalFeatureUseCase
) : ViewModel() {


    private val _actions = MutableSharedFlow<MainFlutterAction>()

    init {
        collectActions()
    }

    fun submitAction(action: MainFlutterAction) {
        viewModelScope.launch {
            _actions.emit(action)
        }
    }

    private fun collectActions() {
        viewModelScope.launch {
            _actions.collect { action ->
                when (action) {
                    is MainFlutterAction.PushFeature -> pushFeatureUseCase.push(action.featureModel)

                }
            }
        }
    }
}