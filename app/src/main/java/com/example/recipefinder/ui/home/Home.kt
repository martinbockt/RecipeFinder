package com.example.recipefinder.ui.home
//
//import androidx.annotation.FloatRange
//import androidx.annotation.StringRes
//import androidx.compose.animation.animateColorAsState
//import androidx.compose.animation.core.Animatable
//import androidx.compose.animation.core.AnimationSpec
//import androidx.compose.animation.core.SpringSpec
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScope
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.foundation.selection.selectable
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Icon
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.outlined.AccountCircle
//import androidx.compose.material.icons.outlined.Home
//import androidx.compose.material.icons.outlined.Search
//import androidx.compose.material.icons.outlined.ShoppingCart
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Shape
//import androidx.compose.ui.graphics.TransformOrigin
//import androidx.compose.ui.graphics.graphicsLayer
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.layout.Layout
//import androidx.compose.ui.layout.MeasureResult
//import androidx.compose.ui.layout.MeasureScope
//import androidx.compose.ui.layout.Placeable
//import androidx.compose.ui.layout.layoutId
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.core.os.ConfigurationCompat
//import androidx.navigation.NavBackStackEntry
//import androidx.navigation.NavGraphBuilder
//import com.example.recipefinder.R
//import com.example.recipefinder.ui.theme.RecipeFinderTheme
//import java.util.Locale
//
//
//enum class HomeSections(
//    @StringRes val title: Int,
//    val icon: ImageVector,
//    val route: String
//) {
//    FEED(R.string.home_feed, Icons.Outlined.Home, "home/feed"),
//    SEARCH(R.string.home_search, Icons.Outlined.Search, "home/search"),
//    CART(R.string.home_cart, Icons.Outlined.ShoppingCart, "home/cart"),
//    PROFILE(R.string.home_profile, Icons.Outlined.AccountCircle, "home/profile")
//}
