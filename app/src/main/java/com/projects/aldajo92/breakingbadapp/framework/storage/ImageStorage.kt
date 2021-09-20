package com.projects.aldajo92.breakingbadapp.framework.storage

import android.graphics.Bitmap

interface ImageStorage {

    fun saveImage(bitmap: Bitmap, filename: String)

    fun loadImage(path: String) : Bitmap?

}