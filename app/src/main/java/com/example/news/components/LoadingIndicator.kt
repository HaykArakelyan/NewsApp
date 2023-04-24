package com.example.news.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoadingIndicator(){
    Box(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}