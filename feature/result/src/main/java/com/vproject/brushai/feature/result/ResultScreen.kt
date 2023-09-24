package com.vproject.brushai.feature.result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vproject.brushai.core.designsystem.component.BrushAiFilledButton
import com.vproject.brushai.core.designsystem.component.BrushAiTopAppBar
import com.vproject.brushai.core.designsystem.component.DynamicAsyncImage
import com.vproject.brushai.core.designsystem.icon.BrushAiIcons

@Composable
internal fun ResultRoute(
    modifier: Modifier = Modifier,
    viewModel: ResultViewModel = hiltViewModel()
) {
    val resultUiState by viewModel.resultUiState.collectAsStateWithLifecycle()
    ResultScreen(
        resultUiState = resultUiState,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
internal fun ResultScreen(
    modifier: Modifier = Modifier,
    resultUiState: ResultUiState,
) {
    Column(modifier = modifier) {
        ResultTopAppBar(onBackClick = {})
        Column(
            Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 80.dp)) {
            Column(Modifier.weight(1f)) {
                ResultImage()
                ResultStyleRow(text = "Digital Art")
                ResultPromptRow()
            }
            ResultButtonRow()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ResultTopAppBar(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
    BrushAiTopAppBar(
        titleRes = R.string.result,
        navigationIcon = BrushAiIcons.RoundedArrowBack,
        navigationIconContentDescription = "Navigation icon",
        onNavigationClick = onBackClick
    )
}

@Composable
private fun ResultImage() {
    val imageModifier = Modifier
        .heightIn(min = 180.dp)
        .fillMaxWidth()
        .clip(shape = MaterialTheme.shapes.medium)
    DynamicAsyncImage(
        imageUrl = "https://cdn.stablediffusionapi.com/generations/87e8bcf4-435d-4415-8a80-0b68e85da425-0.png",
        contentDescription = null,
        modifier = imageModifier
    )
}

@Composable
private fun ResultStyleRow(
    modifier: Modifier = Modifier,
    text: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Style:",
            style = MaterialTheme.typography.titleMedium,
        )

        Text(
            text,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Composable
private fun ResultPromptRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Prompt:",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.Default.CopyAll,
            contentDescription = null,
        )

        Spacer(modifier = Modifier.width(8.dp))
    }
    Text(
        overflow = TextOverflow.Ellipsis,
        text = "Happy charming googly-eyed potato walking around a cardboard diorama town chattingHappy charming googly-eyed potato walking around a cardboard diorama town chattingHappy charming googly-eyed potato walking around a cardboard diorama town chattingHappy charming googly-eyed potato walking around a cardboard diorama town chattingHappy charming googly-eyed potato walking around a cardboard diorama town chattingHappy charming googly-eyed potato walking around a cardboard diorama town chattingHappy charming googly-eyed potato walking around a cardboard diorama town chattingHappy charming googly-eyed potato walking around a cardboard diorama town chatting",
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Composable
private fun ResultButtonRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically) {
        BrushAiFilledButton(
            modifier = Modifier.weight(1f),
            text = { Text(text = "Share") }, onClick = { /*TODO*/ },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Share, contentDescription = null)
            },
        )
        Spacer(modifier = Modifier.width(10.dp))
        BrushAiFilledButton(
            modifier = Modifier.weight(1f),
            text = { Text(text = "Save") }, onClick = { /*TODO*/ },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Download, contentDescription = null)
            },
        )
    }
}

internal object ResultTestTags {

}

@Preview
@Composable
private fun ResultScreenPreview() {
    ResultScreen(resultUiState = ResultUiState.Loading)
}