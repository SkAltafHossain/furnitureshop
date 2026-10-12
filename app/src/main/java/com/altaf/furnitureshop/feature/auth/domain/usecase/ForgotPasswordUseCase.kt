package com.altaf.furnitureshop.feature.auth.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ForgotPasswordUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(email: String): Flow<ResultState<Unit>> {
        return repository.forgotPassword(email)
    }
}