package github.akash1047.rescuebharat.model.screens.splash

import dagger.hilt.android.lifecycle.HiltViewModel
import github.akash1047.rescuebharat.MAIN_SCREEN
import github.akash1047.rescuebharat.SIGN_IN_SCREEN
import github.akash1047.rescuebharat.SIGN_UP_SCREEN
import github.akash1047.rescuebharat.SPLASH_SCREEN
import github.akash1047.rescuebharat.model.MainAppViewModel
import github.akash1047.rescuebharat.model.service.AccountService
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val accountService: AccountService
) : MainAppViewModel() {

    fun onAppStart(openAndPopUp: (String, String) -> Unit) {
        if (accountService.hasUser()) openAndPopUp(MAIN_SCREEN, SPLASH_SCREEN)
//        else openAndPopUp(SIGN_IN_SCREEN, SPLASH_SCREEN)
//        else let user choose the option
    }

    fun onCitizenSignIn(openAndPopUp: (String, String) -> Unit) {
        openAndPopUp(SIGN_IN_SCREEN, SPLASH_SCREEN)
    }

    fun onCitizenSignUp(openAndPopUp: (String, String) -> Unit) {
        openAndPopUp(SIGN_UP_SCREEN, SPLASH_SCREEN)
    }

//    private fun onAdminLogin() {
    // future project
//    }

}