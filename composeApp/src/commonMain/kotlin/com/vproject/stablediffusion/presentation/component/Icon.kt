package com.vproject.stablediffusion.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Stable Diffusion icons. Material icons are [ImageVector]s, custom icons are drawable resource IDs.
 */
object CustomIcons {
    val Home = Icons.Default.Home
    val Project = Icons.Filled.Favorite

    val ArrowBack = Icons.Default.ArrowBack
    val DefaultClose = Icons.Default.Close
    val OutlinedInfo = Icons.Outlined.Info
    val DefaultHistory = Icons.Default.Check
    val Search = Icons.Rounded.Search
}