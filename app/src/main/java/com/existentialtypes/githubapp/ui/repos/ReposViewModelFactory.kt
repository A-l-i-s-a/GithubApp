package com.existentialtypes.githubapp.ui.repos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.existentialtypes.githubapp.network.model.GithubRepositoriesMinimal

class ReposViewModelFactory(
    private val repositoriesMinimal: GithubRepositoriesMinimal
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReposViewModel::class.java)) {
            return ReposViewModel(repositoriesMinimal) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
