package com.example.nond.models.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nond.api.UserApi
import com.example.nond.models.data.UserRequest
import com.example.nond.models.data.UserResponse
import com.example.nond.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApi: UserApi){
    private val _userRepositoryLiveData = MutableLiveData<NetworkResult<UserResponse>>()
    val userRepositoryLiveData: LiveData<NetworkResult<UserResponse>>
        get() = _userRepositoryLiveData
    suspend fun registerUser(userRequest: UserRequest){
        val response = userApi.signup(userRequest)
        handleResponse(response)
    }
    suspend fun loginUser(userRequest: UserRequest){
        val response = userApi.signin(userRequest)
        handleResponse(response)
    }
    private fun handleResponse(response: Response<UserResponse>) {
        if(response.isSuccessful && response.body()!=null)
            _userRepositoryLiveData.postValue(NetworkResult.Success(response.body()!!))
        else if (response.errorBody()!=null){
            val errorObject = JSONObject(response.errorBody()!!.charStream().readText())
            _userRepositoryLiveData.postValue(NetworkResult.Error(errorObject.getString("message")))
        }
        else
            _userRepositoryLiveData.postValue(NetworkResult.Error("Something Went Wrong"))
    }
}