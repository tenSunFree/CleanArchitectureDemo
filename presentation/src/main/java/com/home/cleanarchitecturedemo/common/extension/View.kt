package com.home.cleanarchitecturedemo.common.extension

import android.content.Context
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import androidx.databinding.BindingAdapter
import com.home.cleanarchitecturedemo.common.util.Loggerg

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.setVisible(visible: Boolean, invisible: Boolean? = false) {
    visibility = when {
        visible -> View.VISIBLE
        invisible == true -> View.INVISIBLE
        else -> View.GONE
    }
}

fun View.hideKeyboard() {
    val inputMethod: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethod.hideSoftInputFromWindow(windowToken, 0)
}

fun View.showKeyboard() {
    val inputMethod: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethod.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

inline fun View.afterMeasured(crossinline f: View.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredWidth > 0 && measuredHeight > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                f()
            }
        }
    })
}

/**\
 * requireAll屬性為false, 表示在XML中, 屬性可以不用全部賦值, 默認是true
 */
@BindingAdapter(value = ["singleClick", "hiddenKeyboard"], requireAll = false)
fun View.singleClickListener(singleClick: (() -> Unit)? = null, hiddenKeyboard: Boolean? = false) {
    Loggerg.d("presentation, View.kt, singleClickListener")
    setOnClickListener {
        Loggerg.d("presentation, View.kt, singleClickListener2")
        singleClick?.invoke()
        isClickable = false
        when (hiddenKeyboard) {
            true -> context.showSoftKeyboard(false)
        }

        postDelayed({
            isClickable = true
        }, 300L)
    }
}