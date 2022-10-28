package com.orogersilva.scaffoldandroid.featureapi

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.register(
    featureApi: FeatureApi,
    navHostController: NavHostController
) {
    featureApi.registerGraph(
        navGraphBuilder = this,
        navHostController = navHostController
    )
}
