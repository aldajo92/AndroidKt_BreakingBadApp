package com.projects.aldajo92.breakingbadapp.framework.storage

import android.graphics.Bitmap
import java.io.FileOutputStream
import java.io.IOException

import android.graphics.BitmapFactory
import java.io.File

// TODO: It needs a test
class ImageStorageImpl : ImageStorage {

    override fun saveImage(bitmap: Bitmap, filename: String) {
        try {
            FileOutputStream(filename).use { out ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun loadImage(path: String) = with(File(path)) {
        if (exists()) BitmapFactory.decodeFile(absolutePath)
        else null
    }

}