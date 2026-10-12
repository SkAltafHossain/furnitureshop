package com.altaf.furnitureshop.feature.auth.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.auth.domain.model.User
import com.altaf.furnitureshop.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdatePhoneUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(phone: String, password: String): Flow<ResultState<User>> {
        return repository.updatePhone(phone, password)
    }
}
