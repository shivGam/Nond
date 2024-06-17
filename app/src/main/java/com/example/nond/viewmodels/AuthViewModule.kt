package com.example.nond.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nond.models.data.UserRequest
import com.example.nond.models.data.UserResponse
import com.example.nond.models.repository.UserRepository
import com.example.nond.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModule @Inject constructor(private val userRepository: UserRepository):ViewModel(){

    val userRepositoryLiveData : LiveData<NetworkResult<UserResponse>>
        get() = userRepository.userRepositoryLiveData

    fun registerUser(userRequest: UserRequest){
        viewModelScope.launch {
            userRepository.registerUser(userRequest)
        }
    }
    fun loginUser(userRequest: UserRequest){
        viewModelScope.launch {
            userRepository.loginUser(userRequest)
        }
    }
}