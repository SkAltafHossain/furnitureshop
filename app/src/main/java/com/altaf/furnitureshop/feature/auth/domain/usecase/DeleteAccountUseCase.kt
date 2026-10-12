package com.altaf.furnitureshop.feature.auth.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteAccountUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(password: String): Flow<ResultState<Unit>> {
        return repository.deleteAccount(password)
    }
}
