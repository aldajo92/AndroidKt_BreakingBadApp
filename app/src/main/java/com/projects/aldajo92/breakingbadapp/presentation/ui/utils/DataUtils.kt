package com.projects.aldajo92.breakingbadapp.presentation.ui.utils

fun List<String>.convertListToSingleString(): String {
    return this.reduce{ total, value ->
        "$total, $value"
    }
}