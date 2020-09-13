package com.existentialtypes.githubapp.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AuthorCommit(
    val name: String? = "",
    val email: String? = "",
    val date: String? = ""
) : Parcelable