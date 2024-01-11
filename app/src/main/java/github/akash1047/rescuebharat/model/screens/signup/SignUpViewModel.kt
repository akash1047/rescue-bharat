package github.akash1047.rescuebharat.model.screens.signup

import dagger.hilt.android.lifecycle.HiltViewModel
import github.akash1047.rescuebharat.MAIN_SCREEN
import github.akash1047.rescuebharat.SIGN_UP_SCREEN
import github.akash1047.rescuebharat.model.MainAppViewModel
import github.akash1047.rescuebharat.model.service.AccountService
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

//class SignUpViewModel : ViewModel() {
//    private var username = MutableStateFlow("") // to save synchronous data stream
//    fun setUsername(value: String) {
//        username.value = value
//    }
//
//    private var password = MutableStateFlow("")
//
//    fun setPassword(value: String) {
//        password.value = value
//    }
//
//    private var mobileNumber = MutableStateFlow("")
//    fun setMobileNumber(value: String) {
//        mobileNumber.value = value
//    }
//
//    fun signUpWithEmail() {
////        viewModelScope.launch {
////            try {
////                val auth = FirebaseAuth.getInstance()
////                val result = auth.signInWithEmailAndPassword(
////                    email.value, password.value
////                ).await()
////
////                // Store token securely
////                storeToken(result.user!!.uid, result.user!!.getIdToken(true).await())
////                isLoggedIn.value = true
////            } catch (e: Exception) {
////                error.value = e.message
////            }
//    }
//
//    fun signUpWithNumber() {
//
//    }
//
//    fun loginWithGmail() {

//    }
//}
@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val accountService: AccountService
) : MainAppViewModel() {
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
    val confirmPassword = MutableStateFlow("")

    fun updateEmail(newEmail: String) {
        email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        password.value = newPassword
    }

    fun updateConfirmPassword(newConfirmPassword: String) {
        confirmPassword.value = newConfirmPassword
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        launchCatching {
            if (password.value != confirmPassword.value) {
                throw Exception("Passwords do not match")
            }

            accountService.signUp(email.value, password.value)
            openAndPopUp(MAIN_SCREEN, SIGN_UP_SCREEN)
        }
    }
}