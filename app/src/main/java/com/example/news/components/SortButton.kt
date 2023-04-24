package com.example.news.components

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.entities.Category
import java.util.stream.Stream

@Composable
fun SortButton(
    categories: List<Category>,
    searchBarContent: String,
    onCategoryClick: (String) -> Unit,
    onCategoryClickWithQ: (String, String) -> Unit
) {
    var isDropDownMenuExpanded by remember {
        mutableStateOf(false)
    }

    var selectedCategory by remember {
        mutableStateOf<String>("")
    }


    IconButton(
        onClick = { isDropDownMenuExpanded = true }
    ) {
        Icon(
            Icons.Outlined.Tune,
            contentDescription = "filter",
            tint = Color(0xFF37339A),
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(percent = 10))
                .size(55.dp)
                .rotate(-90f),
        )
    }

    Box(
        contentAlignment = Alignment.Center,
    ) {
        DropdownMenu(
            expanded = isDropDownMenuExpanded,
            onDismissRequest = { isDropDownMenuExpanded = false },
        ) {
            Text(
                text = "Select a category",
                fontSize = 20.sp,
                modifier = Modifier.padding(5.dp),
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic
            )

            categories.forEach { category ->
                DropdownMenuItem(
                    modifier = Modifier.background(
                        if (category.category == selectedCategory) Color(
                            0xFF37339A
                        ) else Color.White
                    ),
                    onClick = {
                        isDropDownMenuExpanded = false
                        selectedCategory = (category.category).lowercase()

                        if (searchBarContent.isEmpty()) {
                            onCategoryClick(selectedCategory)
                        } else {
                            onCategoryClickWithQ(searchBarContent, selectedCategory)
                        }

                    },
                ) {
                    Text(
                        category.category,
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}