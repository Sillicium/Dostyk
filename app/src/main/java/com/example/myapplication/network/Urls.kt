package com.example.myapplication.network

import com.example.myapplication.BuildConfig

enum class BuildTypes{
    debug,  release
}

//const val TEST_URL = BuildConfig.TEST_APP_BASE_URL



object AppBaseURLS {
    val SERVER_BASE_URL = when (BuildConfig.BUILD_TYPE) {
        BuildTypes.release.name -> {
//            BuildConfig.SERVER_BASE_PROD_URL
        }

        else -> {
//            BuildConfig.SERVER_BASE_DEV_URL
        }
    }
}