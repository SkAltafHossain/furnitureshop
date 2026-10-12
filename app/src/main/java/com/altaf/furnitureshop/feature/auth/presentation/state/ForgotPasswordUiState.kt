package com.altaf.furnitureshop.feature.auth.presentation.state

data class ForgotPasswordUiState(
    val isLoading: Boolean = false,
    val email: String = "",
    val errorMessage: String? = null,
    val isSuccess: Boolean = false
)