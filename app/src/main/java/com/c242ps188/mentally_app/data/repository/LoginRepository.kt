package com.c242ps188.mentally_app.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.c242ps188.mentally_app.data.remote.ApiService
import com.c242ps188.mentally_app.data.remote.response.Message
import com.c242ps188.mentally_app.data.remote.response.RegisterResponse
import com.c242ps188.mentally_app.data.remote.response.User
import com.google.gson.Gson
import retrofit2.HttpException
import java.net.SocketTimeoutException

class LoginRepository(
    private val apiService: ApiService
) {

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private var _registerMessage = MutableLiveData<String?>()
    val registerMessage: LiveData<String?> get() = _registerMessage

    private var _registerError = MutableLiveData<String?>()
    val registerError: LiveData<String?> get() = _registerError

    private var _loginResult = MutableLiveData<User?>()
    val loginResult: LiveData<User?> get() = _loginResult

    private var _loginMessage = MutableLiveData<String?>()
    val loginMessage: LiveData<String?> get() = _loginMessage

    private var _userToken = MutableLiveData<String?>()
    val userToken: LiveData<String?> get() = _userToken

    suspend fun register(name: String, email: String, password: String, confPassword: String) {
        _isLoading.value = true
        try {
            val result = apiService.register(name, email, password, confPassword)
            result.error.let {
                _registerError.value = it
            }
            _registerMessage.value = result.message
            _isLoading.value = false
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val result = Gson().fromJson(json, RegisterResponse::class.java)
            _registerMessage.value = result.message
            _isLoading.value = false
        } catch (e: SocketTimeoutException) {
            _registerMessage.value =  e.message
            _isLoading.value = false
        }
    }

    suspend fun login(email: String, password: String) {
        _isLoading.value = true
        try {
            val result = apiService.login(email, password)
            _loginResult.value = result.user
            _userToken.value = result.accessToken
            _loginMessage.value = null
            _isLoading.value = false
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val result = Gson().fromJson(json, Message::class.java)
            _loginMessage.value = result.msg
        } catch (e: SocketTimeoutException) {
            _loginMessage.value =  e.message
            _isLoading.value = false
        }
    }


    companion object {
        @Volatile
        private var instance: LoginRepository? = null

        fun getInstance(apiService: ApiService): LoginRepository {
            return instance ?: synchronized(this) {
                instance ?: LoginRepository(apiService)
            }.also { instance = it }
        }
    }
}