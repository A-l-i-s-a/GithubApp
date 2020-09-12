package com.existentialtypes.githubapp.network

import com.existentialtypes.githubapp.BuildConfig
import com.existentialtypes.githubapp.network.model.GithubRepositories
import com.existentialtypes.githubapp.network.model.GithubRepositoriesMinimal
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL =
    "https://api.github.com/"

private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()

private val client: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(interceptor.setLevel(if (BuildConfig.DEBUG) BODY else NONE))
    .build();

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(client)
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface GithubApiService {
    @GET("repositories")
    fun getRepositories(): Deferred<List<GithubRepositoriesMinimal>>

    @GET("repos/{login}/{name}")
    fun getRepoByFullName(
        @Path("login") login: String,
        @Path("name") name: String
    ): Deferred<GithubRepositories>
}

object GithubApi {
    val RETROFIT_SERVICE: GithubApiService by lazy { retrofit.create(GithubApiService::class.java) }
}
