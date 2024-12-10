package com.c242ps188.mentally_app.data.repository

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

    private val _isLoading: MutableLiveData<Boolean>? = null
    val isLoading: LiveData<Boolean>? get() = _isLoading

    private val _registerMessage: MutableLiveData<String?>? = null
    val registerMessage: LiveData<String?>? get() = _registerMessage

    private val _registerError: MutableLiveData<String?>? = null
    val registerError: LiveData<String?>? get() = _registerError

    private val _loginResult: MutableLiveData<User?>? = null
    val loginResult: LiveData<User?>? get() = _loginResult

    private val _loginMessage: MutableLiveData<String?>? = null
    val loginMessage: LiveData<String?>? get() = _loginMessage

    private val _userToken: MutableLiveData<String?>? = null
    val userToken: LiveData<String?>? get() = _userToken

    suspend fun register(name: String, email: String, password: String, confPassword: String) {
        _isLoading?.value = true
        try {
            val result = apiService.register(name, email, password, confPassword)
            result.error.let {
                _registerError?.value = it
            }
            _registerMessage?.value = result.message
            _isLoading?.value = false
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val result = Gson().fromJson(json, RegisterResponse::class.java)
            _registerError?.value = result.message
            _isLoading?.value = false
        } catch (e: SocketTimeoutException) {
            _registerError?.value =  e.message
            _isLoading?.value = false
        }
    }

    suspend fun login(email: String, password: String) {
        _isLoading?.value = true
        try {
            val result = apiService.login(email, password)
            _loginResult?.value = result.user
            _userToken?.value = result.accessToken
            _isLoading?.value = false
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val result = Gson().fromJson(json, Message::class.java)
            _loginMessage?.value = result.message
        } catch (e: SocketTimeoutException) {
            _loginMessage?.value =  e.message
            _isLoading?.value = false
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