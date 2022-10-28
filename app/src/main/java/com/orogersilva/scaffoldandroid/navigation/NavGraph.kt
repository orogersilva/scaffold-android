package com.orogersilva.scaffoldandroid.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.orogersilva.scaffoldandroid.featureapi.register
import com.orogersilva.scaffoldandroid.newfeatureapi.NewFeatureApi

@Composable
fun NavGraph(
    newFeatureApi: NewFeatureApi
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = newFeatureApi.newRoute()
    ) {
        register(
            newFeatureApi,
            navController
        )
    }
}
