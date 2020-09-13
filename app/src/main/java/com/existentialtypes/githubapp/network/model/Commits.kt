package com.existentialtypes.githubapp.network.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Commits(
    val sha: String? = "",
    val node_id: String? = "",
    val commit: Commit? = Commit(),
    val url: String? = "",
    val html_url: String? = "",
    val comments_url: String? = "",
    val author: Owner? = null,
    val committer: Owner? = null
) : Parcelable