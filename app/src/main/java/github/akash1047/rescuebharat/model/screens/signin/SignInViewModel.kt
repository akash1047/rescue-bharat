package github.akash1047.rescuebharat.model.screens.signin

import github.akash1047.rescuebharat.MAIN_SCREEN
import github.akash1047.rescuebharat.SIGN_IN_SCREEN
import github.akash1047.rescuebharat.SIGN_UP_SCREEN
import github.akash1047.rescuebharat.model.MainAppViewModel
import github.akash1047.rescuebharat.model.service.AccountService
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val accountService: AccountService
) : MainAppViewModel() {


    // no need of user name in signIn
//    private var username = MutableStateFlow("") // to save synchronous data stream
//    fun setUsername(value: String) {
//        username.value = value
//    }

    val password = MutableStateFlow("")
    val email = MutableStateFlow("")

    fun updatePassword(newPassword: String) {
        password.value = newPassword
    }

    fun updateMobileNumber(newMobileNumber: String) {
        email.value = newMobileNumber
    }

    fun onSigInClick(openAndPopUp: (String, String) -> Unit) {
        launchCatching {
            accountService.signIn(email.value, password.value)
            openAndPopUp(MAIN_SCREEN, SIGN_IN_SCREEN)
        }
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        openAndPopUp(SIGN_UP_SCREEN, SIGN_IN_SCREEN)
    }
}
