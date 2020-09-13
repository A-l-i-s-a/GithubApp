package com.existentialtypes.githubapp.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Commit(
    val author: AuthorCommit? = AuthorCommit(),
    val message: String? = "",
    val url: String? = "",
    val comment_count: Int? = 0
) : Parcelable