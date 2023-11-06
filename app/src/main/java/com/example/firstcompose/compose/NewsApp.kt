package com.example.firstcompose.compose

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ShareCompat
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.firstcompose.compose.home.HomeScreen

@Composable
fun NewsApp() {
    val navController = rememberNavController()
    NewsAppNavHost(
        navController = navController
    )
}

@Composable
fun NewsAppNavHost(
    navController: NavHostController
) {
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNewsClick = {
                    createViewIntent(activity, it.link)
                }
            )
        }
    }
}

private fun createViewIntent(activity: Activity, link: String) {
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = Uri.parse(link)
    }
    activity.startActivity(intent)
}