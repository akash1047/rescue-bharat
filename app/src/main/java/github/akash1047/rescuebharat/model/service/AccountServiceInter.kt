package github.akash1047.rescuebharat.model.service

import github.akash1047.rescuebharat.model.screens.User
import kotlinx.coroutines.flow.Flow

interface AccountServiceInter {
    val currentUser: Flow<User?>
    val currentUserId: String
    fun hasUser(): Boolean
    suspend fun signIn(email: String, password: String)
    suspend fun signUp(email: String, password: String)
    suspend fun signOut()
    suspend fun deleteAccount()
}