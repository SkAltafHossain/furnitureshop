package com.altaf.furnitureshop.feature.auth.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.auth.domain.model.AuthResponse
import com.altaf.furnitureshop.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(name: String, email: String, phone: String, password: String, passwordConfirmation: String): Flow<ResultState<AuthResponse>> {
        return repository.register(name, email, phone, password, passwordConfirmation)
    }
}