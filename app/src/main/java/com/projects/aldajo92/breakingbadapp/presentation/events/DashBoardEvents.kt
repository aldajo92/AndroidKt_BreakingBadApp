package com.projects.aldajo92.breakingbadapp.presentation.events

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter

sealed class DashBoardEvents<out T>(val content: T?) : DataEvent<T>(content) {

    class ErrorMessage(message: String) : DashBoardEvents<String>(message)

    class ProductsSuccess(productModels: List<BBCharacter>?) :
        DashBoardEvents<List<BBCharacter>>(productModels)

    class ProductsPaginationSuccess(productModels: List<BBCharacter>?) :
        DashBoardEvents<List<BBCharacter>>(productModels)

    class OpenURL(openUrl: String) :
        DashBoardEvents<String>(openUrl)

}
