package com.altaf.furnitureshop.feature.auth.domain.repository

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.auth.domain.model.AuthResponse
import com.altaf.furnitureshop.feature.auth.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun register(name: String, email: String, phone: String, password: String, passwordConfirmation: String): Flow<ResultState<AuthResponse>>
    fun login(email: String, password: String): Flow<ResultState<AuthResponse>>
    fun forgotPassword(email: String): Flow<ResultState<Unit>>
    fun resetPassword(email: String, token: String, password: String, passwordConfirmation: String): Flow<ResultState<Unit>>
    fun getCurrentUser(): Flow<ResultState<User>>
    fun updateUser(name: String?): Flow<ResultState<User>>
    fun updateEmail(email: String, password: String): Flow<ResultState<User>>
    fun updatePhone(phone: String, password: String): Flow<ResultState<User>>
    fun updatePassword(currentPassword: String, newPassword: String, newPasswordConfirmation: String): Flow<ResultState<Unit>>
    fun deleteAccount(password: String): Flow<ResultState<Unit>>
    fun logout(): Flow<ResultState<Unit>>
}