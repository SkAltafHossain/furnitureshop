package com.altaf.furnitureshop.feature.auth.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.auth.domain.model.AuthResponse
import com.altaf.furnitureshop.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(email: String, password: String): Flow<ResultState<AuthResponse>> {
        return repository.login(email, password)
    }
}