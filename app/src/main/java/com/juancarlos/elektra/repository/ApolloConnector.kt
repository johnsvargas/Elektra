package com.juancarlos.elektra.repository

import android.util.Log
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient




object ApolloConnector {
    private val BASE_URL = "https://stage.ektdevelopers.com/_graphql"
    var index = 0
    val apolloClient: ApolloClient
    get() {
        val okHttpClient = OkHttpClient.Builder().build()
        index.plus(1)
        Log.d("ApolloClient","$index")
        return ApolloClient.builder().serverUrl(BASE_URL).okHttpClient(okHttpClient).build()
    }
}