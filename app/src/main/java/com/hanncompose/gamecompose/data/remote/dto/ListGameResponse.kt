package com.hanncompose.gamecompose.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ListGameResponse(

    @field:SerializedName("results")
    val results:List<GameDto>

)