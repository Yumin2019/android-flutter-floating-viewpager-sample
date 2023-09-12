package org.tensorflow.lite.examples.objectdetection.circlemenu

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.ViewCompat


internal fun Drawable.setTintCompat(color: Int) {
    if (isLollipop()) {
        setTint(color)
    } else {
        val wrapperDrawable = DrawableCompat.wrap(this)
        DrawableCompat.setTintList(wrapperDrawable, ColorStateList.valueOf(color))
    }
}


internal fun isLollipop() = true

fun View.onLaidOut(listener: () -> Unit) {
    onLaidOut(true, listener)
}

/** Executes the given [java.lang.Runnable] when the view is laid out  */
internal fun View.onLaidOut(removeListener: Boolean, listener: () -> Unit) {
    if (isLaidOut(this)) {
        listener()
        return
    }
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (removeListener) {
                removeOnGlobalLayoutListener(viewTreeObserver, this)
            }
            listener()
        }
    })
}

private fun removeOnGlobalLayoutListener(observer: ViewTreeObserver,
                                         listener: ViewTreeObserver.OnGlobalLayoutListener?) {
    if (Build.VERSION.SDK_INT >= 16) {
        observer.removeOnGlobalLayoutListener(listener)
    } else {
        observer.removeGlobalOnLayoutListener(listener)
    }
}

/** Returns whether or not the view has been laid out  */
private fun View.isLaidOut(view: View): Boolean {
    return ViewCompat.isLaidOut(view) && view.width > 0 && view.height > 0
}