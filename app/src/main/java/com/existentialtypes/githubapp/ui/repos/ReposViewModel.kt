package com.existentialtypes.githubapp.ui.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.existentialtypes.githubapp.network.GithubApi
import com.existentialtypes.githubapp.network.model.Commits
import com.existentialtypes.githubapp.network.model.GithubRepositoriesMinimal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ReposViewModel(private val repositories: GithubRepositoriesMinimal) : ViewModel() {

    private val _commits = MutableLiveData<List<Commits>>()

    val commits: LiveData<List<Commits>>
        get() = _commits

    private var viewModelJob = SupervisorJob()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getRepositories()
    }

    private fun getRepositories() {
        coroutineScope.launch {
            // Get the Deferred object for our Retrofit request
            val retrofitService = GithubApi.RETROFIT_SERVICE
            val getCommits =
                retrofitService.getCommits(repositories.owner!!.login!!, repositories.name!!)
            try {
                val listResult = getCommits.await()
                _commits.value = listResult
            } catch (e: Exception) {
                _commits.value = ArrayList()
            }
        }
    }
}