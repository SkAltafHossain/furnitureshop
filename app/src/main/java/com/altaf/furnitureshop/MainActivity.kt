package com.altaf.furnitureshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.altaf.furnitureshop.core.auth.SessionManager
import com.altaf.furnitureshop.core.designsystem.component.AppBar
import com.altaf.furnitureshop.core.designsystem.component.BottomNavigation
import com.altaf.furnitureshop.core.designsystem.theme.AppTheme
import com.altaf.furnitureshop.core.designsystem.theme.LocalShopTheme
import com.altaf.furnitureshop.core.navigation.LocalShopNavigation
import com.altaf.furnitureshop.core.navigation.Screen
import com.altaf.furnitureshop.core.preferences.ThemePreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var sessionManager: SessionManager

    @Inject
    lateinit var themePreferences: ThemePreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isDarkMode by themePreferences.isDarkMode.collectAsState(initial = false)

            LocalShopTheme(darkTheme = isDarkMode) {
                val colors = AppTheme.colors
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colors.pageBackground
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route
                    val isLoggedIn by sessionManager.isLoggedIn.collectAsState(initial = false)

                    val bottomNavItems = listOf(
                        Screen.Home.route,
                        Screen.Products.route,
                        Screen.Categories.route,
                        Screen.Profile.route,
                        Screen.Settings.route
                    )

                    val showBottomNav = currentRoute in bottomNavItems
                    val showAppBar = currentRoute != Screen.Splash.route

                    // Get title based on current route
                    val appBarTitle = when {
                        currentRoute == Screen.Splash.route -> ""
                        currentRoute == Screen.Login.route -> "Login"
                        currentRoute == Screen.Register.route -> "Register"
                        currentRoute == Screen.ForgotPassword.route -> "Forgot Password"
                        currentRoute == Screen.ResetPassword.route -> "Reset Password"
                        currentRoute == Screen.Home.route -> "Home"
                        currentRoute == Screen.Products.route -> "Products"
                        currentRoute == Screen.LatestProducts.route -> "Latest Products"
                        currentRoute == Screen.FeaturedProducts.route -> "Featured Products"
                        currentRoute == Screen.Categories.route -> "Categories"
                        currentRoute == Screen.Search.route -> "Search"
                        currentRoute?.startsWith(Screen.ProductDetails.route.substringBefore("{")) == true -> "Product Details"
                        currentRoute == Screen.Cart.route -> "Cart"
                        currentRoute == Screen.Wishlist.route -> "Wishlist"
                        currentRoute == Screen.Checkout.route -> "Checkout"
                        currentRoute?.startsWith(Screen.CheckoutBuyNow.route.substringBefore("{")) == true -> "Checkout"
                        currentRoute == Screen.AddressManagement.route -> "Address Management"
                        currentRoute == Screen.OrderHistory.route -> "Order History"
                        currentRoute?.startsWith(Screen.OrderDetails.route.substringBefore("{")) == true -> "Order Details"
                        currentRoute == Screen.Profile.route -> "Profile"
                        currentRoute == Screen.Settings.route -> "Settings"
                        currentRoute?.startsWith(Screen.CategoryDetails.route.substringBefore("{")) == true -> "Category Details"
                        else -> "Local Shop"
                    }

                    Scaffold(
                        topBar = {
                            if (showAppBar) {
                                val showSearchIcon = currentRoute != Screen.Search.route
                                AppBar(
                                    title = appBarTitle,
                                    isLoggedIn = isLoggedIn,
                                    onCartClick = {
                                        navController.navigate(Screen.Cart.route)
                                    },
                                    onSearchClick = {
                                        navController.navigate(Screen.Search.route)
                                    },
                                    showSearchIcon = showSearchIcon
                                )
                            }
                        },
                        bottomBar = {
                            if (showBottomNav) {
                                BottomNavigation(
                                    currentRoute = currentRoute ?: Screen.Home.route,
                                    onNavigate = { route ->
                                        navController.navigate(route) {
                                            popUpTo(route) {
                                                inclusive = true
                                            }
                                            launchSingleTop = true
                                        }
                                    }
                                )
                            }
                        }
                    ) { paddingValues ->
                        Box(modifier = Modifier.padding(paddingValues)) {
                            LocalShopNavigation(
                                navController = navController,
                                startDestination = Screen.Home.route
                            )
                        }
                    }
                }
            }
        }
    }
}