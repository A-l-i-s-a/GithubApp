package com.existentialtypes.githubapp.ui.listRepositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.existentialtypes.githubapp.network.GithubApi
import com.existentialtypes.githubapp.network.model.GithubRepositories
import com.existentialtypes.githubapp.network.model.GithubRepositoriesMinimal
import kotlinx.coroutines.*

class ListRepositoriesViewModel : ViewModel() {

    private val _repositories = MutableLiveData<List<GithubRepositoriesMinimal>>()

    val repositories: LiveData<List<GithubRepositoriesMinimal>>
        get() = _repositories

    fun repo(repositoriesMinimal: GithubRepositoriesMinimal): GithubRepositories =
        runBlocking { getRepo(repositoriesMinimal) }

    private var viewModelJob = SupervisorJob()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getRepositories()
    }

    private suspend fun getRepo(repositoriesMinimal: GithubRepositoriesMinimal): GithubRepositories {
        val async = coroutineScope.async(Dispatchers.IO) {
            val async = async {
                // Get the Deferred object for our Retrofit request
                GithubApi.RETROFIT_SERVICE.getRepoByFullName(
                    repositoriesMinimal.owner!!.login!!,
                    repositoriesMinimal.name!!
                ).await()
            }
            async.await()
        }
        return async.await()
    }

    private fun getRepositories() {
        coroutineScope.launch {
            // Get the Deferred object for our Retrofit request
            val retrofitService = GithubApi.RETROFIT_SERVICE
            val getRepositoriesDeferred = retrofitService.getRepositories()
            try {
                val listResult = getRepositoriesDeferred.await()
                _repositories.value = listResult
            } catch (e: Exception) {
                _repositories.value = ArrayList()
            }
        }
    }
}