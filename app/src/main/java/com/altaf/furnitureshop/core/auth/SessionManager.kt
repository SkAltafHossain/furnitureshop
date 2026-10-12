package com.altaf.furnitureshop.core.auth

import com.altaf.furnitureshop.core.network.TokenProvider
import com.altaf.furnitureshop.feature.auth.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    private val tokenProvider: TokenProvider
) {
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: Flow<User?> = _currentUser.asStateFlow()
    
    val isLoggedIn: Flow<Boolean> = tokenProvider.getToken().map { it != null }
    
    fun setCurrentUser(user: User?) {
        _currentUser.value = user
    }
    
    fun clearSession() {
        _currentUser.value = null
    }
}