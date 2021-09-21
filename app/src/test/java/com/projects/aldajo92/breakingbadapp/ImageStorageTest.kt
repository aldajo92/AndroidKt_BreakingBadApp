package com.projects.aldajo92.breakingbadapp

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import androidx.test.core.app.ApplicationProvider
import com.projects.aldajo92.breakingbadapp.framework.storage.ImageStorageImpl
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.File


@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class ImageStorageTest {

    private lateinit var context: Context

    lateinit var bitmap: Bitmap

    lateinit var imageStorage: ImageStorageImpl

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        bitmap = createImage(720, 480, Color.RED)
        imageStorage = ImageStorageImpl()
    }

    @Test
    fun imageSave() {
        val path = "${context.filesDir.path}/stored_images/file.png"
        File(path).mkdir()
        imageStorage.saveImage(bitmap, path)

        val bitmap = imageStorage.loadImage(path)

        assertNotNull(bitmap)
    }

    private fun createImage(width: Int, height: Int, color: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint().apply { setColor(color) }
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
        return bitmap
    }

}