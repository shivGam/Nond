package com.example.nond.models.data


import com.google.gson.annotations.SerializedName

data class  UserResponse(
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: User
)