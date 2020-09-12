package com.existentialtypes.githubapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class License(
    val key: String? = "",
    val name: String? = "",
    @Json(name = "spdx_id")
    val spdxId: String? = "",
    val url: String? = "",
    @Json(name = "node_id")
    val nodeId: String? = ""
) : Parcelable