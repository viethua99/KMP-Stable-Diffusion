package com.vproject.stablediffusion.presentation.screen.project

import cafe.adriel.voyager.core.model.StateScreenModel
import com.vproject.stablediffusion.repository.image.ImageRepository
import cafe.adriel.voyager.core.model.screenModelScope
import com.vproject.stablediffusion.util.imageBitmapFromBytes
import kotlinx.coroutines.launch
import com.vproject.stablediffusion.model.TestSample
import com.vproject.stablediffusion.model.StylePreset
import com.vproject.stablediffusion.model.CanvasPreset
import kotlinx.coroutines.flow.map

class ProjectModel(private val imageRepository: ImageRepository) :
    StateScreenModel<ProjectUiState>(ProjectUiState.Initial) {

    fun getGeneratedImageList() = screenModelScope.launch {
        imageRepository.getProjectInfoList().map { projectInfoList ->
            projectInfoList.map { projectInfo ->
                if (projectInfo.projectType == "tti") {
                    val generatedImageBitmap = imageBitmapFromBytes(projectInfo.generatedImage)
                    TestSample.TextToImageSample(
                        id = projectInfo.id,
                        prompt = projectInfo.prompt,
                        stylePreset = StylePreset.entries.find { it.id == projectInfo.styleId } ?: StylePreset.MODEL_3D,
                        canvasPreset = CanvasPreset.entries.find { it.id == projectInfo.canvasId } ?: CanvasPreset.THREE_FOUR,
                        imageResource = generatedImageBitmap
                    )
                } else {
                    projectInfo.originalImage?.let { nonNullOriginalImage ->
                        val originalImageBitmap = imageBitmapFromBytes(nonNullOriginalImage)
                        val generatedImageBitmap = imageBitmapFromBytes(projectInfo.generatedImage)
                        TestSample.ImageToImageSample(
                            id = projectInfo.id,
                            prompt = projectInfo.prompt,
                            stylePreset = StylePreset.entries.find { it.id == projectInfo.styleId } ?: StylePreset.MODEL_3D,
                            canvasPreset = CanvasPreset.entries.find { it.id == projectInfo.canvasId } ?: CanvasPreset.THREE_FOUR,
                            beforeImageResource = originalImageBitmap,
                            afterImageResource = generatedImageBitmap,
                            )
                    }
                }
            }
        }.collect { projectList ->
            mutableState.value = ProjectUiState.Success(projectList = projectList.filterNotNull())
        }
    }
}
