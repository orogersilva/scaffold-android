package com.orogersilva.scaffoldandroid.newfeature.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.orogersilva.scaffoldandroid.featureapi.FeatureApi
import com.orogersilva.scaffoldandroid.newfeature.ui.screen.NewFeatureComposable
import com.orogersilva.scaffoldandroid.newfeatureapi.NewFeatureApi
import javax.inject.Inject

class NewFeatureFeature @Inject constructor(
    private val newFeatureApi: FeatureApi
) : NewFeatureApi {

    private val baseRoute = "NewFeature"

    override fun newRoute(): String = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController
    ) {
        navGraphBuilder.composable(baseRoute) {
            NewFeatureComposable(newFeatureViewModel = hiltViewModel())
        }
    }
}
