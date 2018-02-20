package com.client.shop.ui.account.di

import com.client.shop.ui.account.contract.*
import com.domain.interactor.account.*
import com.domain.validator.FieldValidator
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides

@Module
class TestAuthModule {

    @Provides
    fun provideSignUpPresenter(formValidator: FieldValidator, signUpUseCase: SignUpUseCase): SignUpPresenter {
        return SignUpPresenter(formValidator, signUpUseCase)
    }

    @Provides
    fun provideSignInPresenter(
        formValidator: FieldValidator,
        signInUseCase: SignInUseCase
    ): SignInPresenter {
        return mock()
    }

    @Provides
    fun provideAuthPresenter(sessionCheckUseCase: SessionCheckUseCase, signOutUseCase: SignOutUseCase,
                             shopInfoUseCase: ShopInfoUseCase, getCustomerUseCase: GetCustomerUseCase): AccountPresenter {
        return AccountPresenter(sessionCheckUseCase, signOutUseCase, shopInfoUseCase, getCustomerUseCase)
    }

    @Provides
    fun provideForgotPasswordPresenter(forgotPasswordUseCase: ForgotPasswordUseCase): ForgotPasswordPresenter {
        return ForgotPasswordPresenter(forgotPasswordUseCase)
    }

    @Provides
    fun providePersonalInfoPresenter(customerUseCase: GetCustomerUseCase,
                                     editCustomerUseCase: EditCustomerUseCase): PersonalInfoPresenter {
        return PersonalInfoPresenter(customerUseCase, editCustomerUseCase)
    }

    @Provides
    fun provideChangePasswordPresenter(): ChangePasswordPresenter {
        return mock()
    }

    @Provides
    fun provideAccountSettingsPresenter(customerUseCase: GetCustomerUseCase,
                                        updateAccountSettingsUseCase: UpdateAccountSettingsUseCase): AccountSettingsPresenter {
        return AccountSettingsPresenter(customerUseCase, updateAccountSettingsUseCase)
    }
}