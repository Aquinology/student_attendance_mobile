package com.example.attendance.data

import com.google.gson.annotations.SerializedName

data class ActivityResponseModel (
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: String
)